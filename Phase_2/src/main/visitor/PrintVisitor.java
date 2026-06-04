package main.visitor;

import main.ast.core.Program;
import main.ast.declarations.*;
import main.ast.declarations.Module;
import main.ast.statements.*;
import main.ast.types.AccessModifier;

public class PrintVisitor extends Visitor<String> {
    private final StringBuilder output = new StringBuilder();

    public String getOutput() {
        return output.toString();
    }

    private void appendLine(String line) {
        output.append(line).append("\n");
    }

    private String access(Member member) {
        AccessModifier modifier = member.getAccessModifier();
        return modifier == null ? "public" : modifier.toString();
    }

    @Override
    public String visit(Program program) {
        int moduleCount = 0;
        int structCount = 0;

        for (TopLevelDecl decl : program.getTopLevelDeclarations()) {
            if (decl instanceof Module || decl instanceof ModuleDecl) {
                moduleCount++;
            } else if (decl instanceof Struct || decl instanceof StructDecl) {
                structCount++;
            }
        }

        appendLine("program [modules:" + moduleCount + " structs:" + structCount + "]");

        for (TopLevelDecl decl : program.getTopLevelDeclarations()) {
            if (decl != null) {
                decl.accept(this);
            }
        }

        return getOutput();
    }

    @Override
    public String visit(ModuleDecl moduleDecl) {
        return moduleDecl.getModule().accept(this);
    }

    @Override
    public String visit(StructDecl structDecl) {
        return structDecl.getStruct().accept(this);
    }

    @Override
    public String visit(Module module) {
        int methodCount = 0;
        int fieldCount = 0;

        for (Member member : module.getMembers()) {
            if (member instanceof MethodDecl) {
                methodCount++;
            } else if (member instanceof VarDecl) {
                fieldCount++;
            }
        }

        appendLine("module " + module.getName()
                + " [methods:" + methodCount
                + " fields:" + fieldCount + "]");

        for (Member member : module.getMembers()) {
            if (member != null) {
                member.accept(this);
            }
        }

        return null;
    }

    @Override
    public String visit(Struct struct) {
        int fieldCount = 0;

        for (Member member : struct.getMembers()) {
            if (member instanceof VarDecl) {
                fieldCount++;
            }
        }

        appendLine("struct " + struct.getName()
                + " [fields:" + fieldCount + "]");

        for (Member member : struct.getMembers()) {
            if (member != null) {
                member.accept(this);
            }
        }

        return null;
    }

    @Override
    public String visit(VarDecl varDecl) {
        Var var = varDecl.getVar();

        appendLine("\tfield "
                + var.getName()
                + " "
                + var.getType()
                + ":"
                + access(varDecl));

        return null;
    }

    @Override
    public String visit(MethodDecl methodDecl) {
        Method method = methodDecl.getMethod();
        int stmtCount = 0;
        if (method.getBody() != null && method.getBody().getStatements() != null) {
            stmtCount = method.getBody().getStatements().size();
        }

        appendLine("\tmethod "
                + method.getName()
                + " "
                + methodType(method)
                + ":"
                + access(methodDecl)
                + " [statements:" + stmtCount + "]");

        return null;
    }

    private String methodType(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        if (method.getParameters() == null || method.getParameters().isEmpty()) {
            sb.append("void");
        } else {
            for (int i = 0; i < method.getParameters().size(); i++) {
                if (i > 0) {
                    sb.append("*");
                }
                sb.append(method.getParameters().get(i).getType());
            }
        }

        sb.append(" -> ");
        sb.append(method.getReturnType());
        sb.append(")");
        return sb.toString();
    }
}
