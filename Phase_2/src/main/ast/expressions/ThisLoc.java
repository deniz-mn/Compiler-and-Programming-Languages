package main.ast.expressions;

import main.visitor.IVisitor;

public class ThisLoc extends Location {
    private Location loc;

    public ThisLoc() {}

    public ThisLoc(Location loc) {
        this.loc = loc;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return loc == null ? "this" : "this." + loc;
    }
}
