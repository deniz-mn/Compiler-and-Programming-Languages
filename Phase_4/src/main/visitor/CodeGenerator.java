package main.visitor;

import main.ast.core.Program;
import main.ast.declarations.*;
import main.ast.declarations.Module;
import main.ast.expressions.*;
import main.ast.expressions.literals.*;
import main.ast.expressions.operators.BinaryOperator;
import main.ast.expressions.operators.UnaryOperator;
import main.ast.statements.*;
import main.ast.types.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CodeGenerator extends Visitor<String> {
    private static final String OUTPUT_PATH = "./codeGenOutput/";
    private static final int JVM_LIMIT = 128;

    private static final class FieldInfo {
        final String name;
        final Type type;
        final AccessModifier access;

        FieldInfo(String name, Type type, AccessModifier access) {
            this.name = name;
            this.type = type;
            this.access = access;
        }
    }

    private static final class MethodInfo {
        final Method method;
        final AccessModifier access;

        MethodInfo(Method method, AccessModifier access) {
            this.method = method;
            this.access = access;
        }
    }

    private static final class ClassInfo {
        final String name;
        final boolean module;
        final List<String> includes = new ArrayList<>();
        final LinkedHashMap<String, FieldInfo> fields = new LinkedHashMap<>();
        final LinkedHashMap<String, MethodInfo> methods = new LinkedHashMap<>();

        ClassInfo(String name, boolean module) {
            this.name = name;
            this.module = module;
        }
    }

    private static final class MethodTarget {
        final ClassInfo owner;
        final MethodInfo method;
        final String includedThrough;

        MethodTarget(ClassInfo owner, MethodInfo method, String includedThrough) {
            this.owner = owner;
            this.method = method;
            this.includedThrough = includedThrough;
        }
    }

    private final LinkedHashMap<String, ClassInfo> classes = new LinkedHashMap<>();
    private final LinkedHashMap<String, Integer> slots = new LinkedHashMap<>();
    private final LinkedHashMap<String, Type> localTypes = new LinkedHashMap<>();
    private final Deque<String> breakLabels = new ArrayDeque<>();
    private final Deque<String> continueLabels = new ArrayDeque<>();

    private FileWriter writer;
    private ClassInfo currentClass;
    private Method currentMethod;
    private int nextSlot;
    private int nextLabel;
    private int nextTemporary;
    private Integer scannerSlot;

    public CodeGenerator() {
        prepareOutputDirectory();
    }

    private void prepareOutputDirectory() {
        File dir = new File(OUTPUT_PATH);
        if (!dir.exists() && !dir.mkdirs())
            throw new IllegalStateException("Cannot create " + OUTPUT_PATH);
    }

    @Override
    public String visit(Program program) {
        classes.clear();
        collectProgramInformation(program);
        validateIncludes();

        MethodTarget entry = findEntryPoint();

        if (classes.containsKey("Main")
                && (entry == null || entry.owner != classes.get("Main"))) {
            throw new IllegalStateException(
                    "A source class named Main must contain the unique entry main method"
            );
        }

        try {
            for (ClassInfo classInfo : classes.values()) {
                generateClass(classInfo, entry);
            }

            if (!classes.containsKey("Main")) {
                generateJvmMain(entry);
            }
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Jasmin code generation failed",
                    exception
           );
        }

        return null;
    }

    private void collectProgramInformation(Program program) {
        for (TopLevelDecl declaration : program.getTopLevelDeclarations()) {
            if (declaration instanceof ModuleDecl) {
                Module module = ((ModuleDecl) declaration).getModule();
                ClassInfo info = new ClassInfo(module.getName().getName(), true);
                for (Identifier include : module.getIncludes())
                    info.includes.add(include.getName());
                collectMembers(info, module.getMembers());
                putClass(info);
            } else if (declaration instanceof StructDecl) {
                Struct struct = ((StructDecl) declaration).getStruct();
                ClassInfo info = new ClassInfo(struct.getName().getName(), false);
                collectMembers(info, struct.getMembers());
                putClass(info);
            }
        }
    }

    private void putClass(ClassInfo info) {
        if (classes.put(info.name, info) != null)
            throw new IllegalStateException("Duplicate module/struct: " + info.name);
    }

    private void collectMembers(ClassInfo owner, List<Member> members) {
        for (Member member : members) {
            if (member instanceof VarDecl) {
                Var var = ((VarDecl) member).getVar();
                Type type = declaredType(var);
                String name = var.getName().getName();
                if (owner.fields.put(name, new FieldInfo(name, type, member.getAccessModifier())) != null)
                    throw new IllegalStateException("Duplicate field " + owner.name + "." + name);
            } else if (member instanceof MethodDecl) {
                Method method = ((MethodDecl) member).getMethod();
                String name = method.getName().getName();
                if (owner.methods.put(name, new MethodInfo(method, member.getAccessModifier())) != null)
                    throw new IllegalStateException("Method overloading is not supported: " + owner.name + "." + name);
            }
        }
    }

    private void validateIncludes() {
        for (ClassInfo info : classes.values()) {
            for (String include : info.includes) {
                ClassInfo included = classes.get(include);
                if (included == null || !included.module)
                    throw new IllegalStateException("Unknown included module " + include + " in " + info.name);
            }
        }
        Map<String, Integer> states = new HashMap<>();
        for (ClassInfo info : classes.values())
            validateIncludeCycle(info, states);
    }

    private void validateIncludeCycle(ClassInfo info, Map<String, Integer> states) {
        int state = states.getOrDefault(info.name, 0);
        if (state == 2)
            return;
        if (state == 1)
            throw new IllegalStateException("Cyclic module include involving " + info.name);
        states.put(info.name, 1);
        for (String include : info.includes)
            validateIncludeCycle(requireClass(include), states);
        states.put(info.name, 2);
    }

    private void generateClass(ClassInfo info, MethodTarget entry) throws IOException {
        currentClass = info;
        try (FileWriter classWriter = new FileWriter(OUTPUT_PATH + info.name + ".j")) {
            writer = classWriter;
            emit(".class public " + info.name);
            emit(".super java/lang/Object");
            emit("");
            writeFields(info);
            writeDefaultConstructor(info);
            if (!info.module && !info.fields.isEmpty())
                writeFullStructConstructor(info);
            for (MethodInfo method : info.methods.values())
                writeMethod(method);
        }
    }

    private void writeFields(ClassInfo info) {
        for (String include : info.includes)
            emit(".field private " + includeField(include) + " L" + include + ";");
        for (FieldInfo field : info.fields.values())
            emit(".field " + accessOf(field.access) + " " + field.name + " " + descriptor(field.type));
        if (!info.includes.isEmpty() || !info.fields.isEmpty())
            emit("");
    }

    private void writeDefaultConstructor(ClassInfo info) {
        emit(".method public <init>()V");
        emit("    .limit stack " + JVM_LIMIT);
        emit("    .limit locals " + JVM_LIMIT);
        emit("    aload_0");
        emit("    invokespecial java/lang/Object/<init>()V");

        for (String include : info.includes) {
            emit("    aload_0");
            emit("    new " + include);
            emit("    dup");
            emit("    invokespecial " + include + "/<init>()V");
            emit("    putfield " + info.name + "/" + includeField(include) + " L" + include + ";");
        }
        for (FieldInfo field : info.fields.values()) {
            emit("    aload_0");
            emitDefaultValue(field.type);
            emit("    putfield " + info.name + "/" + field.name + " " + descriptor(field.type));
        }
        emit("    return");
        emit(".end method");
        emit("");
    }

    private void writeFullStructConstructor(ClassInfo info) {
        StringBuilder arguments = new StringBuilder();
        for (FieldInfo field : info.fields.values())
            arguments.append(descriptor(field.type));

        emit(".method public <init>(" + arguments + ")V");
        emit("    .limit stack " + JVM_LIMIT);
        emit("    .limit locals " + JVM_LIMIT);
        emit("    aload_0");
        emit("    invokespecial java/lang/Object/<init>()V");
        int slot = 1;
        for (FieldInfo field : info.fields.values()) {
            emit("    aload_0");
            emit("    aload " + slot++);
            emit("    putfield " + info.name + "/" + field.name + " " + descriptor(field.type));
        }
        emit("    return");
        emit(".end method");
        emit("");
    }

    private void writeMethod(MethodInfo info) {
        Method method = info.method;
        currentMethod = method;
        resetMethodState();

        StringBuilder arguments = new StringBuilder();
        for (Parameter parameter : method.getParameters()) {
            String name = parameter.getName().getName();
            arguments.append(descriptor(parameter.getType()));
            localTypes.put(name, parameter.getType());
            slotOf(name);
        }

        emit(".method " + accessOf(info.access) + " " + method.getName().getName()
                + "(" + arguments + ")" + descriptor(method.getReturnType()));
        emit("    .limit stack " + JVM_LIMIT);
        emit("    .limit locals " + JVM_LIMIT);
        visit(method.getBody());

        if (isVoid(method.getReturnType())) {
            emit("    return");
        } else {
            emit("    aconst_null");
            emit("    areturn");
        }
        emit(".end method");
        emit("");
        currentMethod = null;
    }

    private void resetMethodState() {
        slots.clear();
        localTypes.clear();
        breakLabels.clear();
        continueLabels.clear();
        nextSlot = 1; // slot zero belongs to this
        nextTemporary = 0;
        scannerSlot = null;
    }

    private int slotOf(String variableName) {
        Integer old = slots.get(variableName);
        if (old != null)
            return old;
        if (nextSlot >= JVM_LIMIT)
            throw new IllegalStateException("Local-variable limit exceeded in " + currentMethod.getName().getName());
        int slot = nextSlot++;
        slots.put(variableName, slot);
        return slot;
    }

    private int temporarySlot() {
        return slotOf("$temp$" + nextTemporary++);
    }

    private void generateJvmMain(MethodTarget entry) throws IOException {
        try (FileWriter mainWriter = new FileWriter(OUTPUT_PATH + "Main.j")) {
            writer = mainWriter;
            emit(".class public Main");
            emit(".super java/lang/Object");
            emit("");
            emit(".method public <init>()V");
            emit("    .limit stack " + JVM_LIMIT);
            emit("    .limit locals " + JVM_LIMIT);
            emit("    aload_0");
            emit("    invokespecial java/lang/Object/<init>()V");
            emit("    return");
            emit(".end method");
            emit("");
            emit(".method public static main([Ljava/lang/String;)V");
            emit("    .limit stack " + JVM_LIMIT);
            emit("    .limit locals " + JVM_LIMIT);

            MethodTarget entry = findEntryPoint();
            if (entry != null) {
                emit("    new " + entry.owner.name);
                emit("    dup");
                emit("    invokespecial " + entry.owner.name + "/<init>()V");
                emit("    invokevirtual " + entry.owner.name + "/main()"
                        + descriptor(entry.method.method.getReturnType()));
                if (!isVoid(entry.method.method.getReturnType()))
                    emit("    pop");
            }
            emit("    return");
            emit(".end method");
        }
    }

    private MethodTarget findEntryPoint() {
        MethodTarget result = null;
        for (ClassInfo info : classes.values()) {
            if (!info.module)
                continue;
            MethodInfo method = info.methods.get("main");
            if (method != null && method.method.getParameters().isEmpty()) {
                if (method.access == AccessModifier.PRIVATE)
                    throw new IllegalStateException(info.name + ".main must be public");
                if (result != null)
                    throw new IllegalStateException("More than one zero-argument module main method");
                result = new MethodTarget(info, method, null);
            }
        }
        return result;
    }

    @Override
    public String visit(Module module) {
        return null;
    }

    @Override
    public String visit(ModuleDecl moduleDecl) {
        return visit(moduleDecl.getModule());
    }

    @Override
    public String visit(Struct struct) {
        return null; 
    }

    @Override
    public String visit(StructDecl structDecl) {
        return visit(structDecl.getStruct());
    }

    @Override
    public String visit(Method method) {
        visit(method.getBody());
        return null;
    }

    @Override
    public String visit(MethodDecl methodDecl) {
        return visit(methodDecl.getMethod());
    }

    @Override
    public String visit(Parameter parameter) {
        return null;
    }

    @Override
    public String visit(Var var) {
        return null;
    }

    @Override
    public String visit(VarDecl varDecl) {
        return visit(varDecl.getVar());
    }

    @Override
    public String visit(Block block) {
        for (Statement statement : block.getStatements())
            statement.accept(this);
        return null;
    }

    @Override
    public String visit(VarDeclStmt statement) {
        Var var = statement.getVar();
        String name = var.getName().getName();
        Type type = declaredType(var);
        if (localTypes.put(name, type) != null)
            throw new IllegalStateException("Duplicate local variable " + name);
        int slot = slotOf(name);

        if (statement.getInitial() != null)
            statement.getInitial().accept(this);
        else if (var.getConstructorCall() != null)
            var.getConstructorCall().accept(this);
        else
            emitDefaultValue(type);
        emit("    astore " + slot);
        return null;
    }

    @Override
    public String visit(AssignStmt statement) {
        statement.getRight().accept(this);
        storeLocation(statement.getLeft());
        return null;
    }

    @Override
    public String visit(MethodCallStmt statement) {
        Type returnType = typeOf(statement.getMethodCall());
        statement.getMethodCall().accept(this);
        if (!isVoid(returnType))
            emit("    pop");
        return null;
    }

    @Override
    public String visit(ReturnStmt statement) {
        if (statement.getValue() == null) {
            emit("    return");
        } else {
            statement.getValue().accept(this);
            emit("    areturn");
        }
        return null;
    }

    @Override
    public String visit(IfStmt statement) {
        String elseLabel = label("if_else");
        String endLabel = label("if_end");

        statement.getCondition().accept(this);
        emitUnbox(boolType());
        emit("    ifeq " + elseLabel);
        statement.getThenBranch().accept(this);
        emit("    goto " + endLabel);
        emitLabel(elseLabel);
        if (statement.getElseBranch() != null)
            statement.getElseBranch().accept(this);
        emitLabel(endLabel);
        return null;
    }

    @Override
    public String visit(ForStmt statement) {
        for (Statement initializer : statement.getInitializers())
            initializer.accept(this);

        String conditionLabel = label("for_condition");
        String updateLabel = label("for_update");
        String endLabel = label("for_end");
        breakLabels.push(endLabel);
        continueLabels.push(updateLabel);

        emitLabel(conditionLabel);
        if (statement.getCondition() != null) {
            statement.getCondition().accept(this);
            emitUnbox(boolType());
            emit("    ifeq " + endLabel);
        }
        statement.getBody().accept(this);
        emitLabel(updateLabel);
        for (AssignStmt updater : statement.getUpdaters())
            updater.accept(this);
        emit("    goto " + conditionLabel);
        emitLabel(endLabel);

        continueLabels.pop();
        breakLabels.pop();
        return null;
    }

    @Override
    public String visit(WhileStmt statement) {
        String conditionLabel = label("while_condition");
        String endLabel = label("while_end");
        breakLabels.push(endLabel);
        continueLabels.push(conditionLabel);

        emitLabel(conditionLabel);
        statement.getCondition().accept(this);
        emitUnbox(boolType());
        emit("    ifeq " + endLabel);
        statement.getBody().accept(this);
        emit("    goto " + conditionLabel);
        emitLabel(endLabel);

        continueLabels.pop();
        breakLabels.pop();
        return null;
    }

    @Override
    public String visit(BreakJump breakJump) {
        if (breakLabels.isEmpty())
            throw new IllegalStateException("break used outside a loop");
        emit("    goto " + breakLabels.peek());
        return null;
    }

    @Override
    public String visit(ContinueJump continueJump) {
        if (continueLabels.isEmpty())
            throw new IllegalStateException("continue used outside a loop");
        emit("    goto " + continueLabels.peek());
        return null;
    }

    @Override
    public String visit(InputStmt statement) {
        Type type = typeOf(statement.getLoc());
        int scanner = scannerSlot();
        emit("    aload " + scanner);
        if (isPrimitive(type, PrimitiveType.Primitive.INT)) {
            emit("    invokevirtual java/util/Scanner/nextInt()I");
        } else if (isPrimitive(type, PrimitiveType.Primitive.FLOAT)) {
            emit("    invokevirtual java/util/Scanner/nextFloat()F");
        } else if (isPrimitive(type, PrimitiveType.Primitive.DOUBLE)) {
            emit("    invokevirtual java/util/Scanner/nextDouble()D");
        } else if (isPrimitive(type, PrimitiveType.Primitive.BOOL)) {
            emit("    invokevirtual java/util/Scanner/nextBoolean()Z");
        } else if (isPrimitive(type, PrimitiveType.Primitive.CHAR)) {
            emit("    invokevirtual java/util/Scanner/next()Ljava/lang/String;");
            emit("    ldc 0");
            emit("    invokevirtual java/lang/String/charAt(I)C");
        } else {
            throw new IllegalStateException("input supports primitive locations only");
        }
        emitBox(type);
        storeLocation(statement.getLoc());
        return null;
    }

    private int scannerSlot() {
        if (scannerSlot != null)
            return scannerSlot;
        scannerSlot = slotOf("$scanner$");
        emit("    new java/util/Scanner");
        emit("    dup");
        emit("    getstatic java/lang/System/in Ljava/io/InputStream;");
        emit("    invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V");
        emit("    astore " + scannerSlot);
        return scannerSlot;
    }

    @Override
    public String visit(OutputStmt statement) {
        emit("    getstatic java/lang/System/out Ljava/io/PrintStream;");
        statement.getValue().accept(this);
        emit("    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V");
        return null;
    }

    @Override
    public String visit(MethodCall call) {
        MethodTarget target;
        if (call.getInstance() == null) {
            target = resolveUnqualifiedMethod(call.getCallee().getName());
            if (target.includedThrough == null) {
                emit("    aload_0");
            } else {
                emit("    aload_0");
                emit("    getfield " + currentClass.name + "/" + includeField(target.includedThrough)
                        + " L" + target.includedThrough + ";");
            }
        } else {
            Type ownerType = typeOf(call.getInstance());
            ClassInfo owner = requireClass(userTypeName(ownerType));
            MethodInfo method = owner.methods.get(call.getCallee().getName());
            if (method == null)
                throw new IllegalStateException("Unknown method " + owner.name + "." + call.getCallee().getName());
            target = new MethodTarget(owner, method, null);
            call.getInstance().accept(this);
        }

        List<Parameter> parameters = target.method.method.getParameters();
        if (parameters.size() != call.getArguments().size())
            throw new IllegalStateException("Wrong argument count for " + target.owner.name + "."
                    + target.method.method.getName().getName());
        for (int i = 0; i < call.getArguments().size(); i++) {
            Expression argument = call.getArguments().get(i);
            if (!descriptor(typeOf(argument)).equals(descriptor(parameters.get(i).getType())))
                throw new IllegalStateException("Wrong type for argument " + (i + 1) + " of "
                        + target.owner.name + "." + target.method.method.getName().getName());
            argument.accept(this);
        }
        emit("    invokevirtual " + target.owner.name + "/" + target.method.method.getName().getName()
                + methodDescriptor(target.method.method));
        return null;
    }

    @Override
    public String visit(ConstructorCall call) {
        String className = call.getName().getName();
        ClassInfo target = requireClass(className);
        if (!call.getArguments().isEmpty()) {
            if (target.module || call.getArguments().size() != target.fields.size())
                throw new IllegalStateException("Constructor arguments must match the fields of struct " + className);
            int index = 0;
            for (FieldInfo field : target.fields.values()) {
                Type argumentType = typeOf(call.getArguments().get(index++));
                if (!descriptor(argumentType).equals(descriptor(field.type)))
                    throw new IllegalStateException("Wrong constructor argument type for " + className + "." + field.name);
            }
        }
        emit("    new " + className);
        emit("    dup");
        StringBuilder arguments = new StringBuilder();
        for (Expression argument : call.getArguments()) {
            argument.accept(this);
            arguments.append(descriptor(typeOf(argument)));
        }
        emit("    invokespecial " + className + "/<init>(" + arguments + ")V");
        return null;
    }

    @Override
    public String visit(SimpleLoc location) {
        loadLocation(location);
        return null;
    }

    @Override
    public String visit(MemberLoc location) {
        loadLocation(location);
        return null;
    }

    @Override
    public String visit(ThisLoc location) {
        loadLocation(location);
        return null;
    }

    @Override
    public String visit(MethodCallLoc location) {
        return visit(location.getMethodCall());
    }

    @Override
    public String visit(ParanthesisExpr expression) {
        return expression.getExpression().accept(this);
    }

    @Override
    public String visit(UnaryOpExpr expression) {
        expression.getOperand().accept(this);
        Type operandType = typeOf(expression.getOperand());
        emitUnbox(operandType);
        if (expression.getOperator() == UnaryOpExpr.Operator.NOT) {
            emit("    ldc 1");
            emit("    ixor");
            emitBox(boolType());
        } else {
            emitNumericNegation(operandType);
            emitBox(operandType);
        }
        return null;
    }

    @Override
    public String visit(UnaryExpression expression) {
        expression.getExpression().accept(this);
        Type operandType = typeOf(expression.getExpression());
        emitUnbox(operandType);
        if (expression.getOperand() == UnaryOperator.NOT) {
            emit("    ldc 1");
            emit("    ixor");
            emitBox(boolType());
        } else {
            emitNumericNegation(operandType);
            emitBox(operandType);
        }
        return null;
    }

    private void emitNumericNegation(Type type) {
        if (isPrimitive(type, PrimitiveType.Primitive.DOUBLE))
            emit("    dneg");
        else if (isPrimitive(type, PrimitiveType.Primitive.FLOAT))
            emit("    fneg");
        else
            emit("    ineg");
    }

    @Override
    public String visit(BinaryExpression expression) {
        BinaryOperator operator = expression.getOperator();
        Type leftType = typeOf(expression.getLeftOperand());
        Type rightType = typeOf(expression.getRightOperand());

        if (operator == BinaryOperator.AND || operator == BinaryOperator.OR) {
            expression.getLeftOperand().accept(this);
            emitUnbox(boolType());
            expression.getRightOperand().accept(this);
            emitUnbox(boolType());
            emit(operator == BinaryOperator.AND ? "    iand" : "    ior");
            emitBox(boolType());
            return null;
        }

        if ((operator == BinaryOperator.EQUALITY || operator == BinaryOperator.INEQUALITY)
                && (!(leftType instanceof PrimitiveType) || !(rightType instanceof PrimitiveType))) {
            expression.getLeftOperand().accept(this);
            expression.getRightOperand().accept(this);
            emitBooleanComparison(operator == BinaryOperator.EQUALITY ? "if_acmpeq" : "if_acmpne");
            return null;
        }

        Type promoted = promotedNumericType(leftType, rightType);
        expression.getLeftOperand().accept(this);
        emitUnbox(leftType);
        emitPromotion(leftType, promoted);
        expression.getRightOperand().accept(this);
        emitUnbox(rightType);
        emitPromotion(rightType, promoted);

        switch (operator) {
            case ADDITION:
            case SUBTRACTION:
            case MULTIPLICATION:
            case DIVISION:
                emitArithmetic(operator, promoted);
                emitBox(promoted);
                break;
            case LESS_THAN:
            case GREATER_THAN:
            case LESS_THAN_OR_EQUAL_TO:
            case GREATER_THAN_OR_EQUAL_TO:
            case EQUALITY:
            case INEQUALITY:
                emitNumericComparison(operator, promoted);
                break;
            default:
                throw new IllegalStateException("Unsupported binary operator " + operator);
        }
        return null;
    }

    private void emitArithmetic(BinaryOperator operator, Type type) {
        String prefix = isPrimitive(type, PrimitiveType.Primitive.DOUBLE) ? "d"
                : isPrimitive(type, PrimitiveType.Primitive.FLOAT) ? "f" : "i";
        String suffix;
        switch (operator) {
            case ADDITION: suffix = "add"; break;
            case SUBTRACTION: suffix = "sub"; break;
            case MULTIPLICATION: suffix = "mul"; break;
            case DIVISION: suffix = "div"; break;
            default: throw new IllegalStateException("Not arithmetic: " + operator);
        }
        emit("    " + prefix + suffix);
    }

    private void emitNumericComparison(BinaryOperator operator, Type type) {
        String jump = comparisonJump(operator);
        if (isPrimitive(type, PrimitiveType.Primitive.DOUBLE)) {
            emit("    " + floatingCompareInstruction("d", operator));
            emitBooleanComparison(jump.replace("if_icmp", "if"));
        } else if (isPrimitive(type, PrimitiveType.Primitive.FLOAT)) {
            emit("    " + floatingCompareInstruction("f", operator));
            emitBooleanComparison(jump.replace("if_icmp", "if"));
        } else {
            emitBooleanComparison(jump);
        }
    }

    private String floatingCompareInstruction(String prefix, BinaryOperator operator) {
        // cmpg makes NaN false for < and <=; cmpl makes it false for > and >=.
        if (operator == BinaryOperator.LESS_THAN || operator == BinaryOperator.LESS_THAN_OR_EQUAL_TO)
            return prefix + "cmpg";
        return prefix + "cmpl";
    }

    private String comparisonJump(BinaryOperator operator) {
        switch (operator) {
            case LESS_THAN: return "if_icmplt";
            case GREATER_THAN: return "if_icmpgt";
            case LESS_THAN_OR_EQUAL_TO: return "if_icmple";
            case GREATER_THAN_OR_EQUAL_TO: return "if_icmpge";
            case EQUALITY: return "if_icmpeq";
            case INEQUALITY: return "if_icmpne";
            default: throw new IllegalStateException("Not a comparison: " + operator);
        }
    }

    private void emitBooleanComparison(String jumpInstruction) {
        String trueLabel = label("comparison_true");
        String endLabel = label("comparison_end");
        emit("    " + jumpInstruction + " " + trueLabel);
        emit("    ldc 0");
        emit("    goto " + endLabel);
        emitLabel(trueLabel);
        emit("    ldc 1");
        emitLabel(endLabel);
        emitBox(boolType());
    }

    @Override
    public String visit(ConstantExpression expression) {
        Object value = expression.getValue();
        if (value instanceof Boolean)
            emit("    ldc " + ((Boolean) value ? 1 : 0));
        else if (value instanceof Character)
            emit("    ldc " + (int) ((Character) value));
        else if (value instanceof Double)
            emit("    ldc2_w " + value);
        else
            emit("    ldc " + value);
        emitBox(typeOf(expression));
        return null;
    }

    @Override
    public String visit(IntLiteral literal) {
        emit("    ldc " + literal.getValue());
        emitBox(intType());
        return null;
    }

    @Override
    public String visit(FloatLiteral literal) {
        emit("    ldc " + literal.getValue());
        emitBox(floatType());
        return null;
    }

    @Override
    public String visit(DoubleLiteral literal) {
        emit("    ldc2_w " + literal.getValue());
        emitBox(doubleType());
        return null;
    }

    @Override
    public String visit(CharLiteral literal) {
        emit("    ldc " + (int) literal.getValue());
        emitBox(charType());
        return null;
    }

    @Override
    public String visit(BoolLiteral literal) {
        emit("    ldc " + (literal.getValue() ? 1 : 0));
        emitBox(boolType());
        return null;
    }

    @Override
    public String visit(Identifier identifier) {
        return visit(new SimpleLoc(identifier));
    }

    @Override
    public String visit(PrimitiveType primitiveType) {
        return descriptor(primitiveType);
    }

    @Override
    public String visit(UserDefinedType userDefinedType) {
        return descriptor(userDefinedType);
    }

    private void loadLocation(Location location) {
        List<String> path = locationPath(location);
        if (path.size() == 1 && "this".equals(path.get(0))) {
            emit("    aload_0");
            return;
        }
        loadPath(path);
    }

    private Type loadPath(List<String> path) {
        if (path.isEmpty()) {
            emit("    aload_0");
            return new UserDefinedType(new Identifier(currentClass.name));
        }

        int index = 0;
        Type type;
        String first = path.get(0);
        if ("this".equals(first)) {
            emit("    aload_0");
            type = new UserDefinedType(new Identifier(currentClass.name));
            index = 1;
        } else if (localTypes.containsKey(first)) {
            emit("    aload " + slotOf(first));
            type = localTypes.get(first);
            index = 1;
        } else if (currentClass.fields.containsKey(first)) {
            FieldInfo field = currentClass.fields.get(first);
            emit("    aload_0");
            emit("    getfield " + currentClass.name + "/" + first + " " + descriptor(field.type));
            type = field.type;
            index = 1;
        } else if (currentClass.includes.contains(first)) {
            emit("    aload_0");
            emit("    getfield " + currentClass.name + "/" + includeField(first) + " L" + first + ";");
            type = new UserDefinedType(new Identifier(first));
            index = 1;
        } else {
            FieldResolution resolution = resolveIncludedField(first);
            emit("    aload_0");
            emit("    getfield " + currentClass.name + "/" + includeField(resolution.include)
                    + " L" + resolution.include + ";");
            emit("    getfield " + resolution.include + "/" + first + " " + descriptor(resolution.field.type));
            type = resolution.field.type;
            index = 1;
        }

        while (index < path.size()) {
            String fieldName = path.get(index++);
            ClassInfo owner = requireClass(userTypeName(type));
            FieldInfo field = owner.fields.get(fieldName);
            if (field == null)
                throw new IllegalStateException("Unknown field " + owner.name + "." + fieldName);
            emit("    getfield " + owner.name + "/" + fieldName + " " + descriptor(field.type));
            type = field.type;
        }
        return type;
    }

    private void storeLocation(Location location) {
        List<String> path = locationPath(location);
        if (path.isEmpty() || (path.size() == 1 && "this".equals(path.get(0))))
            throw new IllegalStateException("Cannot assign to this");

        String first = path.get(0);
        if (path.size() == 1 && localTypes.containsKey(first)) {
            emit("    astore " + slotOf(first));
            return;
        }

        int valueSlot = temporarySlot();
        emit("    astore " + valueSlot);

        String fieldName = path.get(path.size() - 1);
        Type ownerType;
        if (path.size() == 1) {
            if (currentClass.fields.containsKey(first)) {
                emit("    aload_0");
                ownerType = new UserDefinedType(new Identifier(currentClass.name));
            } else {
                FieldResolution resolution = resolveIncludedField(first);
                emit("    aload_0");
                emit("    getfield " + currentClass.name + "/" + includeField(resolution.include)
                        + " L" + resolution.include + ";");
                ownerType = new UserDefinedType(new Identifier(resolution.include));
            }
        } else {
            ownerType = loadPath(path.subList(0, path.size() - 1));
        }

        ClassInfo owner = requireClass(userTypeName(ownerType));
        FieldInfo field = owner.fields.get(fieldName);
        if (field == null)
            throw new IllegalStateException("Unknown field " + owner.name + "." + fieldName);
        emit("    aload " + valueSlot);
        emit("    putfield " + owner.name + "/" + fieldName + " " + descriptor(field.type));
    }

    private List<String> locationPath(Location location) {
        List<String> result = new ArrayList<>();
        appendLocationPath(location, result);
        return result;
    }

    private void appendLocationPath(Location location, List<String> result) {
        if (location instanceof SimpleLoc) {
            result.add(((SimpleLoc) location).getId().getName());
        } else if (location instanceof MemberLoc) {
            MemberLoc member = (MemberLoc) location;
            result.add(member.getMemberName().getName());
            appendLocationPath(member.getLoc(), result);
        } else if (location instanceof ThisLoc) {
            result.add("this");
            if (((ThisLoc) location).getLoc() != null)
                appendLocationPath(((ThisLoc) location).getLoc(), result);
        } else {
            throw new IllegalStateException("Unsupported assignable location " + location.getClass().getSimpleName());
        }
    }

    private Type typeOf(Expression expression) {
        if (expression instanceof ConstantExpression) {
            Object value = ((ConstantExpression) expression).getValue();
            if (value instanceof Integer) return intType();
            if (value instanceof Float) return floatType();
            if (value instanceof Double) return doubleType();
            if (value instanceof Character) return charType();
            if (value instanceof Boolean) return boolType();
        }
        if (expression instanceof IntLiteral) return intType();
        if (expression instanceof FloatLiteral) return floatType();
        if (expression instanceof DoubleLiteral) return doubleType();
        if (expression instanceof CharLiteral) return charType();
        if (expression instanceof BoolLiteral) return boolType();
        if (expression instanceof MethodCallLoc)
            return typeOf(((MethodCallLoc) expression).getMethodCall());
        if (expression instanceof Location) return typeOfLocation((Location) expression);
        if (expression instanceof ConstructorCall)
            return new UserDefinedType(((ConstructorCall) expression).getName());
        if (expression instanceof MethodCall) {
            MethodCall call = (MethodCall) expression;
            if (call.getInstance() == null)
                return resolveUnqualifiedMethod(call.getCallee().getName()).method.method.getReturnType();
            ClassInfo owner = requireClass(userTypeName(typeOf(call.getInstance())));
            MethodInfo method = owner.methods.get(call.getCallee().getName());
            if (method == null)
                throw new IllegalStateException("Unknown method " + owner.name + "." + call.getCallee().getName());
            return method.method.getReturnType();
        }
        if (expression instanceof ParanthesisExpr)
            return typeOf(((ParanthesisExpr) expression).getExpression());
        if (expression instanceof UnaryExpression) {
            UnaryExpression unary = (UnaryExpression) expression;
            return unary.getOperand() == UnaryOperator.NOT ? boolType() : typeOf(unary.getExpression());
        }
        if (expression instanceof UnaryOpExpr) {
            UnaryOpExpr unary = (UnaryOpExpr) expression;
            return unary.getOperator() == UnaryOpExpr.Operator.NOT ? boolType() : typeOf(unary.getOperand());
        }
        if (expression instanceof BinaryExpression) {
            BinaryExpression binary = (BinaryExpression) expression;
            switch (binary.getOperator()) {
                case LESS_THAN:
                case GREATER_THAN:
                case LESS_THAN_OR_EQUAL_TO:
                case GREATER_THAN_OR_EQUAL_TO:
                case EQUALITY:
                case INEQUALITY:
                case AND:
                case OR:
                    return boolType();
                default:
                    return promotedNumericType(typeOf(binary.getLeftOperand()), typeOf(binary.getRightOperand()));
            }
        }
        throw new IllegalStateException("Cannot determine expression type: " + expression.getClass().getSimpleName());
    }

    private Type typeOfLocation(Location location) {
        List<String> path = locationPath(location);
        if (path.size() == 1 && "this".equals(path.get(0)))
            return new UserDefinedType(new Identifier(currentClass.name));

        int index = 0;
        Type type;
        String first = path.get(0);
        if ("this".equals(first)) {
            type = new UserDefinedType(new Identifier(currentClass.name));
            index = 1;
        } else if (localTypes.containsKey(first)) {
            type = localTypes.get(first);
            index = 1;
        } else if (currentClass.fields.containsKey(first)) {
            type = currentClass.fields.get(first).type;
            index = 1;
        } else if (currentClass.includes.contains(first)) {
            type = new UserDefinedType(new Identifier(first));
            index = 1;
        } else {
            type = resolveIncludedField(first).field.type;
            index = 1;
        }

        while (index < path.size()) {
            ClassInfo owner = requireClass(userTypeName(type));
            String fieldName = path.get(index++);
            FieldInfo field = owner.fields.get(fieldName);
            if (field == null)
                throw new IllegalStateException("Unknown field " + owner.name + "." + fieldName);
            type = field.type;
        }
        return type;
    }

    private static final class FieldResolution {
        final String include;
        final FieldInfo field;

        FieldResolution(String include, FieldInfo field) {
            this.include = include;
            this.field = field;
        }
    }

    private FieldResolution resolveIncludedField(String name) {
        FieldResolution result = null;
        for (String include : currentClass.includes) {
            FieldInfo field = requireClass(include).fields.get(name);
            if (field != null) {
                if (result != null)
                    throw new IllegalStateException("Ambiguous included field " + name);
                result = new FieldResolution(include, field);
            }
        }
        if (result == null)
            throw new IllegalStateException("Unknown variable/field " + name);
        return result;
    }

    private MethodTarget resolveUnqualifiedMethod(String name) {
        MethodInfo local = currentClass.methods.get(name);
        if (local != null)
            return new MethodTarget(currentClass, local, null);

        MethodTarget result = null;
        for (String include : currentClass.includes) {
            ClassInfo owner = requireClass(include);
            MethodInfo method = owner.methods.get(name);
            if (method != null) {
                if (result != null)
                    throw new IllegalStateException("Ambiguous included method " + name);
                result = new MethodTarget(owner, method, include);
            }
        }
        if (result == null)
            throw new IllegalStateException("Unknown method " + name + " in " + currentClass.name);
        return result;
    }

    private String methodDescriptor(Method method) {
        StringBuilder result = new StringBuilder("(");
        for (Parameter parameter : method.getParameters())
            result.append(descriptor(parameter.getType()));
        return result.append(")").append(descriptor(method.getReturnType())).toString();
    }

    private Type declaredType(Var var) {
        if (var.getType() != null)
            return var.getType();
        if (var.getConstructorCall() != null)
            return new UserDefinedType(var.getConstructorCall().getName());
        throw new IllegalStateException("Variable " + var.getName().getName() + " has no type");
    }

    private String descriptor(Type type) {
        if (type instanceof UserDefinedType)
            return "L" + ((UserDefinedType) type).getId().getName() + ";";
        PrimitiveType.Primitive primitive = ((PrimitiveType) type).getPrimitive();
        switch (primitive) {
            case INT: return "Ljava/lang/Integer;";
            case FLOAT: return "Ljava/lang/Float;";
            case DOUBLE: return "Ljava/lang/Double;";
            case CHAR: return "Ljava/lang/Character;";
            case BOOL: return "Ljava/lang/Boolean;";
            case VOID: return "V";
            default: throw new IllegalStateException("Unknown primitive " + primitive);
        }
    }

    private void emitDefaultValue(Type type) {
        if (type instanceof UserDefinedType) {
            emit("    aconst_null");
        } else if (isPrimitive(type, PrimitiveType.Primitive.DOUBLE)) {
            emit("    ldc2_w 0.0");
            emitBox(type);
        } else if (isPrimitive(type, PrimitiveType.Primitive.FLOAT)) {
            emit("    ldc 0.0");
            emitBox(type);
        } else if (!isVoid(type)) {
            emit("    ldc 0");
            emitBox(type);
        } else {
            throw new IllegalStateException("A variable cannot have type void");
        }
    }

    private void emitUnbox(Type type) {
        if (!(type instanceof PrimitiveType) || isVoid(type))
            return;
        PrimitiveType.Primitive primitive = ((PrimitiveType) type).getPrimitive();
        switch (primitive) {
            case INT:
                emit("    checkcast java/lang/Integer");
                emit("    invokevirtual java/lang/Integer/intValue()I");
                break;
            case FLOAT:
                emit("    checkcast java/lang/Float");
                emit("    invokevirtual java/lang/Float/floatValue()F");
                break;
            case DOUBLE:
                emit("    checkcast java/lang/Double");
                emit("    invokevirtual java/lang/Double/doubleValue()D");
                break;
            case CHAR:
                emit("    checkcast java/lang/Character");
                emit("    invokevirtual java/lang/Character/charValue()C");
                break;
            case BOOL:
                emit("    checkcast java/lang/Boolean");
                emit("    invokevirtual java/lang/Boolean/booleanValue()Z");
                break;
            default:
                throw new IllegalStateException("Cannot unbox " + primitive);
        }
    }

    private void emitBox(Type type) {
        PrimitiveType.Primitive primitive = ((PrimitiveType) type).getPrimitive();
        switch (primitive) {
            case INT: emit("    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;"); break;
            case FLOAT: emit("    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;"); break;
            case DOUBLE: emit("    invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;"); break;
            case CHAR: emit("    invokestatic java/lang/Character/valueOf(C)Ljava/lang/Character;"); break;
            case BOOL: emit("    invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;"); break;
            default: throw new IllegalStateException("Cannot box " + primitive);
        }
    }

    private Type promotedNumericType(Type left, Type right) {
        if (isPrimitive(left, PrimitiveType.Primitive.DOUBLE)
                || isPrimitive(right, PrimitiveType.Primitive.DOUBLE)) return doubleType();
        if (isPrimitive(left, PrimitiveType.Primitive.FLOAT)
                || isPrimitive(right, PrimitiveType.Primitive.FLOAT)) return floatType();
        return intType();
    }

    private void emitPromotion(Type from, Type to) {
        if (isPrimitive(to, PrimitiveType.Primitive.DOUBLE)) {
            if (isPrimitive(from, PrimitiveType.Primitive.FLOAT)) emit("    f2d");
            else if (!isPrimitive(from, PrimitiveType.Primitive.DOUBLE)) emit("    i2d");
        } else if (isPrimitive(to, PrimitiveType.Primitive.FLOAT)
                && !isPrimitive(from, PrimitiveType.Primitive.FLOAT)) {
            emit("    i2f");
        }
    }

    private boolean isPrimitive(Type type, PrimitiveType.Primitive primitive) {
        return type instanceof PrimitiveType && ((PrimitiveType) type).getPrimitive() == primitive;
    }

    private boolean isVoid(Type type) {
        return isPrimitive(type, PrimitiveType.Primitive.VOID);
    }

    private String userTypeName(Type type) {
        if (!(type instanceof UserDefinedType))
            throw new IllegalStateException("Member access needs a struct/module value, got " + type.getStr());
        return ((UserDefinedType) type).getId().getName();
    }

    private ClassInfo requireClass(String name) {
        ClassInfo info = classes.get(name);
        if (info == null)
            throw new IllegalStateException("Unknown module/struct " + name);
        return info;
    }

    private String includeField(String moduleName) {
        return "__include_" + moduleName;
    }

    private String accessOf(AccessModifier access) {
        return access == AccessModifier.PRIVATE ? "private" : "public";
    }

    private String label(String prefix) {
        return prefix + "_" + nextLabel++;
    }

    private void emitLabel(String label) {
        emit(label + ":");
    }

    private void emit(String command) {
        try {
            writer.write(command);
            writer.write('\n'); 
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot write Jasmin command", exception);
        }
    }

    private PrimitiveType intType() {
        return new PrimitiveType(PrimitiveType.Primitive.INT);
    }

    private PrimitiveType floatType() {
        return new PrimitiveType(PrimitiveType.Primitive.FLOAT);
    }

    private PrimitiveType doubleType() {
        return new PrimitiveType(PrimitiveType.Primitive.DOUBLE);
    }

    private PrimitiveType charType() {
        return new PrimitiveType(PrimitiveType.Primitive.CHAR);
    }

    private PrimitiveType boolType() {
        return new PrimitiveType(PrimitiveType.Primitive.BOOL);
    }
}
