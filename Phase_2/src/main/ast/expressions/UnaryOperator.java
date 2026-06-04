package main.ast.expressions;

public enum UnaryOperator {
    MINUS("-"),
    NOT("not");

    private final String symbol;

    UnaryOperator(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
