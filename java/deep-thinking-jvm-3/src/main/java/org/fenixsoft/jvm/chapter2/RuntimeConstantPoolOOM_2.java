package org.fenixsoft.jvm.chapter2;

public class RuntimeConstantPoolOOM_2 {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        System.out.println(str1.intern() == "计算机软件");
        System.out.println(str1.intern() == new String("计算机软件"));

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
        System.out.println("java" == str2.intern());
        System.out.println("java" == str2);
    }
}
