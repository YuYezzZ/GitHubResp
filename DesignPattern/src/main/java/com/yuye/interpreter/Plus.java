package com.yuye.interpreter;

public class Plus implements AbstractExpression{
    private AbstractExpression left;
    private AbstractExpression right;

    public Plus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
      return   left.interpret(context)+right.interpret(context);
    }

    @Override
    public String toString() {
        return left.toString()+"+"+right.toString();
    }
}
