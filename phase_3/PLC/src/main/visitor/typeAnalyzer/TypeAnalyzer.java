package main.visitor.typeAnalyzer;

import main.ast.core.Program;
import main.ast.declarations.*;
import main.ast.declarations.Module;
import main.ast.expressions.*;
import main.ast.expressions.operators.BinaryOperator;
import main.ast.statements.*;
import main.ast.types.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.*;
import main.visitor.Visitor;

import java.util.List;

public class TypeAnalyzer extends Visitor<Type> {
    private Type currentMethodReturnType;
    private String currentOwnerName;

    @Override
    public Type visit(Program program) {
        if (SymbolTable.root == null) {
            return null;
        }
        SymbolTable.push(SymbolTable.root);
        for (TopLevelDecl decl : program.getTopLevelDeclarations()) {
            decl.accept(this);
        }
        SymbolTable.pop();
        return null;
    }

    @Override
    public Type visit(ModuleDecl moduleDecl) {
        Module module = moduleDecl.getModule();
        SymbolTableItem item = getRootItem(module.getName().getName());
        if (item == null) {
            return null;
        }
        currentOwnerName = module.getName().getName();
        SymbolTable.push(item.getInnerSymbolTable());
        for (Member member : module.getMembers()) {
            member.accept(this);
        }
        SymbolTable.pop();
        currentOwnerName = null;
        return null;
    }

    @Override
    public Type visit(StructDecl structDecl) {
        Struct struct = structDecl.getStruct();
        SymbolTableItem item = getRootItem(struct.getName().getName());
        if (item == null) {
            return null;
        }
        currentOwnerName = struct.getName().getName();
        SymbolTable.push(item.getInnerSymbolTable());
        for (Member member : struct.getMembers()) {
            member.accept(this);
        }
        SymbolTable.pop();
        currentOwnerName = null;
        return null;
    }

    @Override
    public Type visit(MethodDecl methodDecl) {
        methodDecl.getMethod().accept(this);
        return null;
    }

    @Override
    public Type visit(Method method) {
        Type previous = currentMethodReturnType;
        currentMethodReturnType = method.getReturnType();
        SymbolTable.push(new SymbolTable());
        for (Parameter parameter : method.getParameters()) {
            VarItem item = new VarItem(parameter.getName().getName(), parameter.getType(), parameter.getIsMutable(), "public");
            item.setInitialized(true);
            try {
                SymbolTable.top.put(item);
            } catch (Exception ignored) {
            }
        }
        method.getBody().accept(this);
        SymbolTable.pop();
        currentMethodReturnType = previous;
        return null;
    }

    @Override
    public Type visit(Block block) {
        SymbolTable.push(new SymbolTable());
        for (Statement statement : block.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Type visit(VarDeclStmt stmt) {
        Type leftType = stmt.getVar().getType();

        if (leftType == null && stmt.getVar().getConstructorCall() != null) {
            leftType = new UserDefinedType(new Identifier(stmt.getVar().getConstructorCall().getName().getName()));
        }

        VarItem varItem = new VarItem(
                stmt.getVar().getName().getName(),
                leftType,
                stmt.getVar().getIsMutable(),
                "public"
        );

        varItem.setInitialized(stmt.getInitial() != null || stmt.getVar().getConstructorCall() != null);

        try {
            SymbolTable.top.put(varItem);
        } catch (Exception ignored) {
        }

        if (stmt.getInitial() != null) {
            Type rightType = stmt.getInitial().accept(this);

            if (!sameType(leftType, rightType)) {
                printAssignMismatch(stmt.getLine(), rightType, leftType);
            }
        }

        if (stmt.getVar().getConstructorCall() != null) {
            stmt.getVar().getConstructorCall().accept(this);
        }

        return null;
    }

    @Override
    public Type visit(AssignStmt stmt) {
        Type leftType = stmt.getLeft().accept(this);
        Type rightType = stmt.getRight().accept(this);
        SymbolTableItem leftItem = stmt.getLeft().accept(new LocationItemVisitor());
        if (leftItem != null && leftItem.getKind() == SymbolKind.VARIABLE && !leftItem.isMut()) {
            System.out.println("Line " + stmt.getLine() + " : Cannot modify immutable variable " + leftItem.getName());
        }
        if (!sameType(leftType, rightType)) {
            printAssignMismatch(stmt.getLine(), rightType, leftType);
        }
        return null;
    }

    @Override
    public Type visit(IfStmt stmt) {
        Type conditionType = stmt.getCondition().accept(this);

        if (conditionType == null) {
            SymbolTableItem item = stmt.getCondition().accept(new LocationItemVisitor());
            if (item != null) {
                conditionType = item.getType();
            }
        }

        if (conditionType == null || !"bool".equals(conditionType.getStr())) {
            System.out.println("Line " + stmt.getCondition().getLine() + " : Condition type must be bool");
        }

        stmt.getThenBranch().accept(this);

        if (stmt.getElseBranch() != null) {
            stmt.getElseBranch().accept(this);
        }

        return null;
    }

    @Override
    public Type visit(WhileStmt stmt) {
        Type conditionType = stmt.getCondition().accept(this);

        if (conditionType != null && !"bool".equals(conditionType.getStr())) {
            System.out.println("Line " + stmt.getCondition().getLine() + " : Condition type must be bool");
        }

        stmt.getBody().accept(this);
        return null;
    }

    @Override
    public Type visit(ForStmt stmt) {
        SymbolTable.push(new SymbolTable());
        for (Statement initializer : stmt.getInitializers()) {
            initializer.accept(this);
        }
        if (stmt.getCondition() != null) {
            Type conditionType = stmt.getCondition().accept(this);
            if (!isBool(conditionType)) {
                System.out.println("Line " + stmt.getLine() + " : Condition type must be bool");
            }
        }
        for (AssignStmt updater : stmt.getUpdaters()) {
            updater.accept(this);
        }
        stmt.getBody().accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Type visit(ReturnStmt stmt) {
        Type actual = new PrimitiveType(PrimitiveType.Primitive.VOID);
        if (stmt.getValue() != null) {
            actual = stmt.getValue().accept(this);
        }
        if (!sameType(currentMethodReturnType, actual)) {
            System.out.println("Line " + stmt.getLine() + " : Return type mismatch. Expected " + typeName(currentMethodReturnType) + ", got " + typeName(actual));
        }
        return null;
    }

    @Override
    public Type visit(MethodCallStmt stmt) {
        stmt.getMethodCall().accept(this);
        return null;
    }

    @Override
    public Type visit(OutputStmt stmt) {
        stmt.getValue().accept(this);
        return null;
    }

    @Override
    public Type visit(InputStmt stmt) {
        SymbolTableItem item = stmt.getLoc().accept(new LocationItemVisitor());
        if (item != null && item.getKind() == SymbolKind.VARIABLE && !item.isMut()) {
            System.out.println("Line " + stmt.getLine() + " : Cannot modify immutable variable " + item.getName());
        }
        return null;
    }

    @Override
    public Type visit(SimpleLoc simpleLoc) {
        SymbolTableItem item = simpleLoc.accept(new LocationItemVisitor());
        return item == null ? null : item.getType();
    }

    @Override
    public Type visit(MemberLoc memberLoc) {
        SymbolTableItem item = memberLoc.accept(new LocationItemVisitor());
        return item == null ? null : item.getType();
    }
   
    @Override
    public Type visit(ThisLoc thisLoc) {
        if (thisLoc.getLoc() == null) {
            return new UserDefinedType(new Identifier(currentOwnerName));
        }

        SymbolTableItem item = resolveMember(
                new UserDefinedType(new Identifier(currentOwnerName)),
                thisLoc.getLoc()
        );

        return item == null ? null : item.getType();
    }

    @Override
    public Type visit(MethodCall methodCall) {
        SymbolTableItem methodItem = resolveMethod(methodCall);
        if (methodItem == null) {
            for (Expression arg : methodCall.getArguments()) {
                arg.accept(this);
            }
            return null;
        }
        List<Type> expectedTypes = methodItem.getParameterTypes();
        List<Expression> args = methodCall.getArguments();
        if (expectedTypes.size() != args.size()) {
            System.out.println("Line " + methodCall.getLine() + " : Argument count mismatch for method " + methodCall.getCallee().getName() + ". Expected " + expectedTypes.size() + ", got " + args.size());
        } else {
            for (int i = 0; i < args.size(); i++) {
                Type actual = args.get(i).accept(this);
                Type expected = expectedTypes.get(i);
                if (!sameType(expected, actual)) {
                    System.out.println("Line " + methodCall.getLine() + " : Argument type mismatch for method " + methodCall.getCallee().getName() + ", parameter " + (i + 1) + ". Expected " + typeName(expected) + ", got " + typeName(actual));
                    break;
                }
            }
        }
        return methodItem.getReturnType();
    }

    @Override
    public Type visit(ConstructorCall constructorCall) {
        for (Expression arg : constructorCall.getArguments()) {
            arg.accept(this);
        }
        return new UserDefinedType(new Identifier(constructorCall.getName().getName()));
    }

    @Override
    public Type visit(ConstantExpression constantExpression) {
        Object value = constantExpression.getValue();
        Class<?> c = value.getClass();
        if (c == Integer.class) {
            return new PrimitiveType(PrimitiveType.Primitive.INT);
        }
        if (c == Float.class) {
            return new PrimitiveType(PrimitiveType.Primitive.FLOAT);
        }
        if (c == Double.class) {
            return new PrimitiveType(PrimitiveType.Primitive.DOUBLE);
        }
        if (c == Character.class) {
            return new PrimitiveType(PrimitiveType.Primitive.CHAR);
        }
        if (c == Boolean.class) {
            return new PrimitiveType(PrimitiveType.Primitive.BOOL);
        }
        return null;
    }

    @Override
    public Type visit(BinaryExpression expr) {
        Type left = expr.getLeftOperand().accept(this);
        Type right = expr.getRightOperand().accept(this);
        BinaryOperator op = expr.getOperator();
        if (op == BinaryOperator.LESS_THAN || op == BinaryOperator.GREATER_THAN ||
            op == BinaryOperator.LESS_THAN_OR_EQUAL_TO || op == BinaryOperator.GREATER_THAN_OR_EQUAL_TO ||
            op == BinaryOperator.EQUALITY || op == BinaryOperator.INEQUALITY ||
            op == BinaryOperator.AND || op == BinaryOperator.OR) {
            return new PrimitiveType(PrimitiveType.Primitive.BOOL);
        }
        if (sameType(left, right)) {
            return left;
        }
        return left;
    }

    @Override
    public Type visit(UnaryExpression expr) {
        Type t = expr.getExpression().accept(this);
        if ("not".equals(expr.getOperand().getSymbol())) {
            return new PrimitiveType(PrimitiveType.Primitive.BOOL);
        }
        return t;
    }

    @Override
    public Type visit(ParanthesisExpr expr) {
        return expr.getExpression().accept(this);
    }

    private class LocationItemVisitor extends Visitor<SymbolTableItem> {
        @Override
        public SymbolTableItem visit(SimpleLoc simpleLoc) {
            try {
                return SymbolTable.top.get(simpleLoc.getId().getName());
            } catch (ItemNotFoundException e) {
                return null;
            }
        }

        @Override
        public SymbolTableItem visit(ThisLoc thisLoc) {
            return getRootItem(currentOwnerName);
        }

        @Override
        public SymbolTableItem visit(MemberLoc memberLoc) {
            String baseName = memberLoc.getMemberName().getName();
            try {
                SymbolTableItem base = SymbolTable.top.get(baseName);
                return resolveMember(base.getType(), memberLoc.getLoc());
            } catch (ItemNotFoundException e) {
                return null;
            }
        }
    }

    private SymbolTableItem resolveMember(Type baseType, Location memberPath) {
        if (baseType == null) {
            return null;
        }
        SymbolTableItem owner = getRootItem(baseType.getStr());
        if (owner == null || owner.getInnerSymbolTable() == null) {
            return null;
        }
        String memberName = memberPath.accept(new LocationNameVisitor());
        if (memberName == null) {
            return null;
        }
        try {
            return owner.getInnerSymbolTable().getInCurrentScope(memberName);
        } catch (ItemNotFoundException e) {
            return null;
        }
    }

    private class LocationNameVisitor extends Visitor<String> {
        @Override
        public String visit(SimpleLoc simpleLoc) {
            return simpleLoc.getId().getName();
        }

        @Override
        public String visit(MemberLoc memberLoc) {
            return memberLoc.getMemberName().getName();
        }
    }

    private SymbolTableItem resolveMethod(MethodCall methodCall) {
        try {
            if (methodCall.getInstance() == null) {
                SymbolTableItem item = SymbolTable.top.get(methodCall.getCallee().getName());
                return item.getKind() == SymbolKind.METHOD ? item : null;
            }
            Type instanceType = methodCall.getInstance().accept(this);
            if (instanceType == null) {
                return null;
            }
            SymbolTableItem owner = getRootItem(instanceType.getStr());
            if (owner == null || owner.getInnerSymbolTable() == null) {
                return null;
            }
            SymbolTableItem item = owner.getInnerSymbolTable().getInCurrentScope(methodCall.getCallee().getName());
            return item.getKind() == SymbolKind.METHOD ? item : null;
        } catch (ItemNotFoundException e) {
            return null;
        }
    }

    private SymbolTableItem getRootItem(String name) {
        try {
            return SymbolTable.root.getInCurrentScope(name);
        } catch (ItemNotFoundException e) {
            return null;
        }
    }

    private boolean sameType(Type a, Type b) {
        if (a == null || b == null) {
            return true;
        }
        return typeName(a).equals(typeName(b));
    }

    private boolean isBool(Type type) {
        return type != null && "bool".equals(typeName(type));
    }

    private String typeName(Type type) {
        return type == null ? "unknown" : type.getStr();
    }

    private void printAssignMismatch(int line, Type source, Type target) {
        System.out.println("Line " + line + " : Type mismatch in assignment. Cannot assign " + typeName(source) + " to " + typeName(target));
    }
}
