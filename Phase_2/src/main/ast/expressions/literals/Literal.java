package main.ast.expressions.literals;

import main.ast.expressions.Expression;

public abstract class Literal<TValue> extends Expression {
    private TValue value;

    public Literal(TValue value) {
        this.value = value;
    }

    public TValue getValue() {
        return value;
    }

    public void setValue(TValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
