package com.epam.memory;

public class StackOverflowExceptionBasedOnExplicitRecursionApplication {
    private static int counter = 0;

    public static void main(String[] args) {
            test();

    }


    public static void test() {
        int i = 15;
        counter++;
        test();
    }
}
