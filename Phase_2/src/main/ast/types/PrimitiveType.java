package main.ast.types;

import main.visitor.IVisitor;

public class PrimitiveType extends Type {
    private String name;

    public PrimitiveType(String name) {
        this.name = name;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
