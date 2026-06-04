package main.ast.expressions;

import main.ast.types.Identifier;
import main.visitor.IVisitor;

public class SimpleLoc extends Location {
    private Identifier name;

    public SimpleLoc(Identifier name) {
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
