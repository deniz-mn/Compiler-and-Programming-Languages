package main.visitor.nameAnalyzer;

import main.ast.core.Program;
import main.ast.declarations.*;
import main.ast.declarations.Module;
import main.ast.expressions.*;
import main.ast.statements.*;
import main.ast.types.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.*;
import main.visitor.Visitor;

import java.util.*;


public class NameAnalyzer extends Visitor<Void> {
    private enum Phase { DECLARE_TOP_LEVELS, DECLARE_MEMBERS, ANALYZE_BODIES }

    private Phase phase;
    private String currentOwnerName;
    private String currentAccess;
    private boolean leftSideOfAssignment;
    private final Map<String, Set<String>> dependencies = new HashMap<>();
    private final Map<String, Integer> declarationLines = new HashMap<>();
    private final Map<String, List<String>> includeMap = new HashMap<>();

    @Override
    public Void visit(Program program) {
        SymbolTable.root = new SymbolTable();
        SymbolTable.top = null;
        SymbolTable.push(SymbolTable.root);

        phase = Phase.DECLARE_TOP_LEVELS;
        for (TopLevelDecl decl : program.getTopLevelDeclarations()) {
            decl.accept(this);
        }

        phase = Phase.DECLARE_MEMBERS;
        for (TopLevelDecl decl : program.getTopLevelDeclarations()) {
            decl.accept(this);
        }

        phase = Phase.ANALYZE_BODIES;
        for (TopLevelDecl decl : program.getTopLevelDeclarations()) {
            decl.accept(this);
        }

        printUnreachableWarnings(program);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(ModuleDecl moduleDecl) {
        Module module = moduleDecl.getModule();
        String name = module.getName().getName();

        if (phase == Phase.DECLARE_TOP_LEVELS) {
            declarationLines.put(name, module.getLine());
            dependencies.putIfAbsent(name, new HashSet<>());
            includeMap.putIfAbsent(name, new ArrayList<>());

            try {
                SymbolTable.root.put(new ModuleItem(name));
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Line " + module.getLine() + " : " + name + " already defined");
            }
            return null;
        }

        SymbolTableItem item = getRootItem(name);
        if (item == null) {
            return null;
        }

        currentOwnerName = name;
        SymbolTable.push(item.getInnerSymbolTable());

        if (phase == Phase.DECLARE_MEMBERS) {
        for (Identifier include : module.getIncludes()) {
            dependencies.get(name).add(include.getName());
            includeMap.get(name).add(include.getName());

            if (getRootItem(include.getName()) == null) {
                System.out.println("Line " + include.getLine() + " : " + include.getName() + " not declared");
            }
        }
            for (Member member : module.getMembers()) {
                member.accept(this);
            }
        } else {
            for (Member member : module.getMembers()) {
                member.accept(this);
            }
        }

        SymbolTable.pop();
        currentOwnerName = null;
        return null;
    }

    @Override
    public Void visit(StructDecl structDecl) {
        Struct struct = structDecl.getStruct();
        String name = struct.getName().getName();

        if (phase == Phase.DECLARE_TOP_LEVELS) {
            declarationLines.put(name, struct.getLine());
            dependencies.putIfAbsent(name, new HashSet<>());
            try {
                SymbolTable.root.put(new StructItem(name));
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Line " + struct.getLine() + " : " + name + " already defined");
            }
            return null;
        }

        SymbolTableItem item = getRootItem(name);
        if (item == null) {
            return null;
        }

        currentOwnerName = name;
        SymbolTable.push(item.getInnerSymbolTable());
        for (Member member : struct.getMembers()) {
            member.accept(this);
        }
        SymbolTable.pop();
        currentOwnerName = null;
        return null;
    }

    @Override
    public Void visit(MethodDecl methodDecl) {
        currentAccess = accessToString(methodDecl.getAccessModifier());
        methodDecl.getMethod().accept(this);
        currentAccess = null;
        return null;
    }

    @Override
    public Void visit(VarDecl varDecl) {
        currentAccess = accessToString(varDecl.getAccessModifier());
        if (phase == Phase.DECLARE_MEMBERS) {
            declareVariable(varDecl.getVar(), currentAccess, false);
        }
        currentAccess = null;
        return null;
    }

    @Override
    public Void visit(Method method) {
        String name = method.getName().getName();
        if (phase == Phase.DECLARE_MEMBERS) {
            MethodItem item = new MethodItem(name, method.getReturnType(), currentAccess);
            for (Parameter parameter : method.getParameters()) {
                item.addParameterType(parameter.getType());
            }
            try {
                SymbolTable.top.put(item);
            } catch (ItemAlreadyExistsException e) {
                if (!"main".equals(name)) {
                    System.out.println("Line " + method.getLine() + " : " + name + " already defined");
                }
            }
            return null;
        }

        if (phase == Phase.ANALYZE_BODIES) {
            SymbolTable methodScope = new SymbolTable();
            SymbolTable.push(methodScope);
            for (Parameter parameter : method.getParameters()) {
                VarItem paramItem = new VarItem(parameter.getName().getName(), parameter.getType(), parameter.getIsMutable(), "public");
                paramItem.setInitialized(true);
                try {
                    SymbolTable.top.put(paramItem);
                } catch (ItemAlreadyExistsException e) {
                    System.out.println("Line " + parameter.getLine() + " : " + parameter.getName().getName() + " already defined");
                }
            }
            method.getBody().accept(this);
            SymbolTable.pop();
        }
        return null;
    }

    @Override
    public Void visit(Block block) {
        SymbolTable.push(new SymbolTable());
        for (Statement statement : block.getStatements()) {
            statement.accept(this);
        }
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(VarDeclStmt stmt) {
        VarItem item = declareVariable(stmt.getVar(), "public", stmt.getInitial() != null || stmt.getVar().getConstructorCall() != null);
        if (stmt.getVar().getConstructorCall() != null) {
            stmt.getVar().getConstructorCall().accept(this);
        }
        if (stmt.getInitial() != null) {
            stmt.getInitial().accept(this);
            if (item != null) {
                item.setInitialized(true);
            }
        }
        return null;
    }

    @Override
    public Void visit(AssignStmt stmt) {
        leftSideOfAssignment = true;
        SymbolTableItem item = stmt.getLeft().accept(new LocationItemVisitor());
        leftSideOfAssignment = false;

        if (item != null && item.getKind() == SymbolKind.VARIABLE && !item.isMut()) {
            String name = stmt.getLeft().accept(new LocationNameVisitor());
            System.out.println("Line " + stmt.getLine() + " : Cannot modify immutable variable " + name);
        }

        stmt.getRight().accept(this);

        if (item != null && item.getKind() == SymbolKind.VARIABLE) {
            item.setInitialized(true);
        }

        return null;
    }

    @Override
    public Void visit(MethodCallStmt stmt) {
        stmt.getMethodCall().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCall methodCall) {
        SymbolTableItem methodItem = resolveMethod(methodCall);
        if (methodItem == null) {
            System.out.println("Line " + methodCall.getLine() + " : " + methodCall.getCallee().getName() + " not declared");
        }
        for (Expression argument : methodCall.getArguments()) {
            argument.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConstructorCall constructorCall) {
        String typeName = constructorCall.getName().getName();
        if (getRootItem(typeName) == null) {
            System.out.println("Line " + constructorCall.getLine() + " : " + typeName + " not declared");
        } else {
            addDependency(typeName);
        }
        for (Expression arg : constructorCall.getArguments()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SimpleLoc simpleLoc) {
        simpleLoc.accept(new LocationItemVisitor());
        return null;
    }

    @Override
    public Void visit(MemberLoc memberLoc) {
        memberLoc.accept(new LocationItemVisitor());
        return null;
    }

    
    @Override
    public Void visit(ThisLoc thisLoc) {
        if (thisLoc.getLoc() != null) {
            resolveMember(
                    new UserDefinedType(new Identifier(currentOwnerName)),
                    thisLoc.getLoc(),
                    thisLoc.getLine()
            );
        }
        return null;
    }

    @Override
    public Void visit(BinaryExpression expr) {
        expr.getLeftOperand().accept(this);
        expr.getRightOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression expr) {
        expr.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(ParanthesisExpr expr) {
        expr.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(IfStmt stmt) {
        stmt.getCondition().accept(this);
        stmt.getThenBranch().accept(this);
        if (stmt.getElseBranch() != null) {
            stmt.getElseBranch().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(WhileStmt stmt) {
        stmt.getCondition().accept(this);
        stmt.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(ForStmt stmt) {
        SymbolTable.push(new SymbolTable());
        for (Statement initializer : stmt.getInitializers()) {
            initializer.accept(this);
        }
        if (stmt.getCondition() != null) {
            stmt.getCondition().accept(this);
        }
        for (AssignStmt updater : stmt.getUpdaters()) {
            updater.accept(this);
        }
        stmt.getBody().accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(ReturnStmt stmt) {
        if (stmt.getValue() != null) {
            stmt.getValue().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(InputStmt stmt) {
        leftSideOfAssignment = true;
        SymbolTableItem item = stmt.getLoc().accept(new LocationItemVisitor());
        leftSideOfAssignment = false;
        if (item != null && item.getKind() == SymbolKind.VARIABLE) {
            item.setInitialized(true);
        }
        return null;
    }

    @Override
    public Void visit(OutputStmt stmt) {
        stmt.getValue().accept(this);
        return null;
    }

    private VarItem declareVariable(Var var, String visibility, boolean initialized) {
        String name = var.getName().getName();
        Type type = var.getType();

        if (type == null && var.getConstructorCall() != null) {
            String typeName = var.getConstructorCall().getName().getName();
            type = new UserDefinedType(new Identifier(typeName));
            addDependency(typeName);
        }

        if (type != null) {
            checkUserType(type, var.getLine());
        }

        VarItem item = new VarItem(name, type, var.getIsMutable(), visibility);

        boolean shouldBeInitialized = initialized;
        if (type != null && !isPrimitiveName(type.getStr())) {
            shouldBeInitialized = true;
        }

        item.setInitialized(shouldBeInitialized);

        try {
            SymbolTable.top.put(item);
        } catch (ItemAlreadyExistsException e) {
            System.out.println("Line " + var.getLine() + " : " + name + " already defined");
            return null;
        }

        return item;
    }


    private void checkUserType(Type type, int line) {
        String name = type.getStr();
        if (!isPrimitiveName(name) && getRootItem(name) == null) {
            System.out.println("Line " + line + " : " + name + " not declared");
        }
        if (!isPrimitiveName(name)) {
            addDependency(name);
        }
    }

    private SymbolTableItem resolveMethod(MethodCall methodCall) {
        try {
            if (methodCall.getInstance() == null) {
                SymbolTableItem item = SymbolTable.top.get(methodCall.getCallee().getName());
                if (item.getKind() == SymbolKind.METHOD) {
                    return item;
                }
                return null;
            }
            Type instanceType = methodCall.getInstance().accept(new LocationTypeVisitor());
            if (instanceType == null) {
                return null;
            }
            SymbolTableItem owner = getRootItem(instanceType.getStr());
            if (owner == null || owner.getInnerSymbolTable() == null) {
                return null;
            }
            SymbolTableItem methodItem = lookupIncludedMember(instanceType.getStr(), methodCall.getCallee().getName(), new HashSet<>());

            if (methodItem == null || methodItem.getKind() != SymbolKind.METHOD) {
                return null;
            }

            if (!sameOwner(instanceType.getStr()) && isPrivate(methodItem)) {
                System.out.println("Line " + methodCall.getLine() + " : " + methodCall.getCallee().getName() + " is private");
            }

            addDependency(instanceType.getStr());
            return methodItem;
        } catch (ItemNotFoundException e) {
            return null;
        }
    }

    private class LocationItemVisitor extends Visitor<SymbolTableItem> {
        
    @Override
    public SymbolTableItem visit(SimpleLoc simpleLoc) {
        String name = simpleLoc.getId().getName();
        try {
            SymbolTableItem item = SymbolTable.top.get(name);

            if (!leftSideOfAssignment &&
                    item.getKind() == SymbolKind.VARIABLE &&
                    !item.isInitialized() &&
                    isPrimitiveVariable(item)) {
                System.out.println("Line " + simpleLoc.getLine() + " : " + name + " is uninitialized");
            }

            return item;
        } catch (ItemNotFoundException e) {
            System.out.println("Line " + simpleLoc.getLine() + " : " + name + " not declared");
            return null;
        }
    }

        @Override
        public SymbolTableItem visit(ThisLoc thisLoc) {
            if (thisLoc.getLoc() == null) {
                return getRootItem(currentOwnerName);
            }
            return resolveMember(new UserDefinedType(new Identifier(currentOwnerName)), thisLoc.getLoc(), thisLoc.getLine());
        }

        @Override
    public SymbolTableItem visit(MemberLoc memberLoc) {
        String baseName = memberLoc.getMemberName().getName();
        try {
            SymbolTableItem base = SymbolTable.top.get(baseName);

            if (base.getKind() == SymbolKind.VARIABLE &&
                    !leftSideOfAssignment &&
                    !base.isInitialized() &&
                    isPrimitiveVariable(base)) {
                System.out.println("Line " + memberLoc.getLine() + " : " + baseName + " is uninitialized");
            }

            return resolveMember(base.getType(), memberLoc.getLoc(), memberLoc.getLine());
        } catch (ItemNotFoundException e) {
            System.out.println("Line " + memberLoc.getLine() + " : " + baseName + " not declared");
            return null;
        }
    }
    }

    private class LocationTypeVisitor extends Visitor<Type> {
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
            return new UserDefinedType(new Identifier(currentOwnerName));
        }
    }

    private SymbolTableItem resolveMember(Type baseType, Location memberPath, int line) {
    if (baseType == null) {
        return null;
    }

    SymbolTableItem owner = getRootItem(baseType.getStr());
    if (owner == null || owner.getInnerSymbolTable() == null) {
        System.out.println("Line " + line + " : " + baseType.getStr() + " not declared");
        return null;
    }

    addDependency(baseType.getStr());

    String memberName = memberPath.accept(new LocationNameVisitor());
    if (memberName == null) {
        return null;
    }

    SymbolTableItem member = lookupIncludedMember(baseType.getStr(), memberName, new HashSet<>());

    if (member == null) {
        System.out.println("Line " + memberPath.getLine() + " : " + memberName + " not declared");
        return null;
    }

    if (!sameOwner(baseType.getStr()) && isPrivate(member)) {
        System.out.println("Line " + memberPath.getLine() + " : " + memberName + " is private");
    }

    if (!leftSideOfAssignment &&
            member.getKind() == SymbolKind.VARIABLE &&
            !member.isInitialized() &&
            isPrimitiveVariable(member)) {
        System.out.println("Line " + memberPath.getLine() + " : " + memberName + " is uninitialized");
    }

    return member;
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

        @Override
        public String visit(ThisLoc thisLoc) {
            return "this";
        }
    }

    private void printUnreachableWarnings(Program program) {
        if (!dependencies.containsKey("Main")) {
            return;
        }
        Set<String> reachable = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        reachable.add("Main");
        queue.add("Main");
        while (!queue.isEmpty()) {
            String current = queue.remove();
            for (String dep : dependencies.getOrDefault(current, new HashSet<>())) {
                if (!reachable.contains(dep)) {
                    reachable.add(dep);
                    queue.add(dep);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : declarationLines.entrySet()) {
            if (!reachable.contains(entry.getKey())) {
                System.out.println("Warning Line " + entry.getValue() + " : " + entry.getKey() + " is unreachable");
            }
        }
    }

    private SymbolTableItem getRootItem(String name) {
        try {
            return SymbolTable.root.getInCurrentScope(name);
        } catch (ItemNotFoundException e) {
            return null;
        }
    }

    private void addDependency(String name) {
        if (currentOwnerName != null && dependencies.containsKey(currentOwnerName) && name != null && !isPrimitiveName(name)) {
            dependencies.get(currentOwnerName).add(name);
        }
    }

    private boolean isPrimitiveName(String name) {
        return "int".equals(name) || "float".equals(name) || "double".equals(name) || "char".equals(name) || "bool".equals(name) || "void".equals(name);
    }

    private String accessToString(AccessModifier accessModifier) {
        if (accessModifier == AccessModifier.PRIVATE) {
            return "private";
        }
        return "public";
    }

    private boolean isPrivate(SymbolTableItem item) {
        return "private".equals(item.getVisibility());
    }

    private boolean sameOwner(String name) {
        return currentOwnerName != null && currentOwnerName.equals(name);
    }

    private boolean isPrimitiveVariable(SymbolTableItem item) {
        return item != null &&
                item.getKind() == SymbolKind.VARIABLE &&
                item.getType() != null &&
                isPrimitiveName(item.getType().getStr());
    }

   private SymbolTableItem lookupIncludedMember(String ownerName, String memberName, Set<String> visited) {
    if (ownerName == null || visited.contains(ownerName)) {
        return null;
    }

    visited.add(ownerName);

    SymbolTableItem owner = getRootItem(ownerName);
    if (owner == null || owner.getInnerSymbolTable() == null) {
        return null;
    }

    try {
        return owner.getInnerSymbolTable().getInCurrentScope(memberName);
    } catch (ItemNotFoundException ignored) {
    }

    for (String includedName : includeMap.getOrDefault(ownerName, new ArrayList<>())) {
        SymbolTableItem found = lookupIncludedMember(includedName, memberName, visited);
        if (found != null) {
            return found;
        }
    }

    return null;
}

}
