package main.ast.types;

import main.visitor.IVisitor;

public class UserDefinedType extends Type {
    private Identifier name;

    public UserDefinedType(Identifier name) {
        this.name = name;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Identifier getName() {
        return name;
    }

    public void setName(Identifier name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
