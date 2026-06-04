package main.ast.expressions;

import main.ast.types.Identifier;
import main.visitor.IVisitor;

public class MemberLoc extends Location {
    private Identifier instanceName;
    private Location member;

    public MemberLoc(Identifier instanceName, Location member) {
        this.instanceName = instanceName;
        this.member = member;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Identifier getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(Identifier instanceName) {
        this.instanceName = instanceName;
    }

    public Location getMember() {
        return member;
    }

    public void setMember(Location member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return instanceName + "." + member;
    }
}
