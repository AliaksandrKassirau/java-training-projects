package com.epam.memory;

public class StringPoolApplication {

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = "cba";

        System.out.println(a == b);
    }
}

class FinalClass {

}

class FinalExample {
    private final int  i = 0;
    private final FinalClass obj = new FinalClass();
}
