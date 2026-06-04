package main.visitor;

import main.ast.core.Program;
import main.ast.declarations.*;
import main.ast.declarations.Module;
import main.ast.statements.*;

public class TestVisitor extends Visitor<Void> {
    private int moduleCount;
    private int structCount;
    private int methodCount;
    private int fieldCount;
    private int statementCount;

    @Override
    public Void visit(Program program) {
        for (TopLevelDecl decl : program.getTopLevelDeclarations()) {
            if (decl != null) {
                decl.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(ModuleDecl moduleDecl) {
        if (moduleDecl.getModule() != null) {
            moduleDecl.getModule().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(StructDecl structDecl) {
        if (structDecl.getStruct() != null) {
            structDecl.getStruct().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Module module) {
        moduleCount++;
        for (Member member : module.getMembers()) {
            if (member != null) {
                member.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(Struct struct) {
        structCount++;
        for (Member member : struct.getMembers()) {
            if (member != null) {
                member.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(MethodDecl methodDecl) {
        methodCount++;
        Method method = methodDecl.getMethod();
        if (method != null && method.getBody() != null) {
            method.getBody().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(VarDecl varDecl) {
        fieldCount++;
        return null;
    }

    @Override
    public Void visit(Block block) {
        for (Statement statement : block.getStatements()) {
            if (statement != null) {
                statementCount++;
                statement.accept(this);
            }
        }
        return null;
    }

    public int getModuleCount() { return moduleCount; }
    public int getStructCount() { return structCount; }
    public int getMethodCount() { return methodCount; }
    public int getFieldCount() { return fieldCount; }
    public int getStatementCount() { return statementCount; }

    public String summary() {
        return "modules=" + moduleCount
                + ", structs=" + structCount
                + ", methods=" + methodCount
                + ", fields=" + fieldCount
                + ", statements=" + statementCount;
    }
}
