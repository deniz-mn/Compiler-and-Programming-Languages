package main.ast.expressions;

public enum BinaryOperator {
    MULTIPLY("*"),
    DIVIDE("/"),
    PLUS("+"),
    MINUS("-"),
    LESS("<"),
    GREATER(">"),
    LESS_EQUAL("<="),
    GREATER_EQUAL(">="),
    EQUAL("=="),
    NOT_EQUAL("!="),
    AND("and"),
    OR("or");

    private final String symbol;

    BinaryOperator(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
