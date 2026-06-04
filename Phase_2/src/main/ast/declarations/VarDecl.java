package main.ast.declarations;

import main.ast.types.AccessModifier;
import main.visitor.IVisitor;

public class VarDecl extends Member {
    private Var var;

    public VarDecl() {}

    public VarDecl(AccessModifier accessModifier, Var var) {
        this.setAccessModifier(accessModifier);
        this.var = var;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Var getVar() {
        return var;
    }

    public void setVar(Var var) {
        this.var = var;
    }
}