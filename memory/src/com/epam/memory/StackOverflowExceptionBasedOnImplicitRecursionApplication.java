package com.epam.memory;

public class StackOverflowExceptionBasedOnImplicitRecursionApplication {

    public static void main(String[] args) {
        new B();
    }
}

class A {
    private B b = new B();
}

class B {
    private A a = new A();
}
