package main.symbolTable.items;

import main.symbolTable.SymbolTable;

public class StructItem extends SymbolTableItem {
    private SymbolTable structSymbolTable;

    public StructItem(String name) {
        this.name = name;
        this.structSymbolTable = new SymbolTable();
    }

    @Override
    public SymbolKind getKind() {
        return SymbolKind.STRUCT;
    }

    @Override
    public SymbolTable getInnerSymbolTable() {
        return structSymbolTable;
    }

    public SymbolTable getStructSymbolTable() {
        return structSymbolTable;
    }
}
