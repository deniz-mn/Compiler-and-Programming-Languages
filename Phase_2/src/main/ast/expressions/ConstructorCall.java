package main.ast.expressions;

import main.ast.types.Identifier;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class ConstructorCall extends Expression {
    private Identifier typeName;
    private List<Expression> arguments;

    public ConstructorCall(Identifier typeName) {
        this.typeName = typeName;
        this.arguments = new ArrayList<>();
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void addArgument(Expression argument) {
        arguments.add(argument);
    }

    public Identifier getTypeName() {
        return typeName;
    }

    public void setTypeName(Identifier typeName) {
        this.typeName = typeName;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public void setArguments(List<Expression> arguments) {
        this.arguments = arguments;
    }
}
