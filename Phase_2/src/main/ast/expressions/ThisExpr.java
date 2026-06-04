package main.ast.expressions;

import main.visitor.IVisitor;

public class ThisExpr extends Expression {
    public ThisExpr() {}

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "this";
    }
}
