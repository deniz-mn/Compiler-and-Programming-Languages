package main.ast.types;

public enum AccessModifier {
    PUBLIC,
    PRIVATE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
