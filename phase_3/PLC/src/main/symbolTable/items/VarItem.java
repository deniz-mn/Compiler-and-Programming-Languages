package main.symbolTable.items;

import main.ast.types.Type;

public class VarItem extends SymbolTableItem {
    private Type type;
    private boolean isMut;
    private boolean isInitialized;
    private String visibility;

    public VarItem(String name, Type type, boolean isMut, String visibility) {
        this.name = name;
        this.type = type;
        this.isMut = isMut;
        this.isInitialized = false;
        this.visibility = visibility == null ? "public" : visibility;
    }

    @Override
    public SymbolKind getKind() {
        return SymbolKind.VARIABLE;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public boolean isMut() {
        return isMut;
    }

    @Override
    public boolean isInitialized() {
        return isInitialized;
    }

    @Override
    public void setInitialized(boolean initialized) {
        isInitialized = initialized;
    }

    @Override
    public String getVisibility() {
        return visibility;
    }
}
