package main.symbolTable.items;

import main.ast.types.Type;
import main.symbolTable.SymbolTable;

import java.util.ArrayList;

public abstract class SymbolTableItem {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SymbolKind getKind() {
        return null;
    }

    public Type getType() {
        return null;
    }

    public Type getReturnType() {
        return null;
    }

    public ArrayList<Type> getParameterTypes() {
        return new ArrayList<>();
    }

    public boolean isMut() {
        return false;
    }

    public boolean isInitialized() {
        return true;
    }

    public void setInitialized(boolean initialized) {
    }

    public String getVisibility() {
        return "public";
    }

    public SymbolTable getInnerSymbolTable() {
        return null;
    }
}
