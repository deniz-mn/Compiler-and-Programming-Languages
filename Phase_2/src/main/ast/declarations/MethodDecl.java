package main.ast.declarations;

import main.ast.types.AccessModifier;
import main.visitor.IVisitor;

public class MethodDecl extends Member {
    private Method method;

    public MethodDecl() {}

    public MethodDecl(AccessModifier accessModifier, Method method) {
        this.setAccessModifier(accessModifier);
        this.method = method;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}