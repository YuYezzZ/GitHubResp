package com.yuye.interpreter;

public class Client {
    //程序入口
    public static void main(String[] args) {
        Context context = new Context();
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        Variable d = new Variable("d");
        context.assign(a,1);
        context.assign(b,2);
        context.assign(c,3);
        context.assign(d,4);
        //a+b+c-d
        AbstractExpression r1 = new Minus(new Plus(new Plus(a, b), c), d);
        System.out.println(r1);
        int interpret1 = r1.interpret(context);
        System.out.println(interpret1);
        System.out.println("========================");
        //a-b-c+d
        AbstractExpression r2 =new Plus(new Minus(new Minus(a,b),c),d);
        System.out.println(r2);
        int interpret2 = r2.interpret(context);
        System.out.println(interpret2);
    }
}
