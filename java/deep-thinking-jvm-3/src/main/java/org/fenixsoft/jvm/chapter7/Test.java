package org.fenixsoft.jvm.chapter7;

public class Test {
    static {
        i=2;
        System.out.println(i);
    }
    static int i=1;

    public static void main(String[] args) {
        System.out.println(Test.i);
    }
}
