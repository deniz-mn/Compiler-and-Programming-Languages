package main.ast.expressions;

import java.util.ArrayList;
import java.util.List;

import main.ast.types.Identifier;
import main.visitor.IVisitor;

public class MethodCall extends Expression {
    private Location instance;
    private Identifier callee;
    private List<Expression> arguments;

    public MethodCall() {
        this.arguments = new ArrayList<>();
    }

    public MethodCall(Identifier callee) {
        this();
        this.callee = callee;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void addArgument(Expression argument) {
        arguments.add(argument);
    }

    public Location getInstance() {
        return instance;
    }

    public void setInstance(Location instance) {
        this.instance = instance;
    }

    public Identifier getCallee() {
        return callee;
    }

    public void setCallee(Identifier callee) {
        this.callee = callee;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public void setArguments(List<Expression> arguments) {
        this.arguments = arguments;
    }


    public MethodCall(Location instance, Identifier callee) {
        this();
        this.instance = instance;
        this.callee = callee;
    }
}
