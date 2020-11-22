package org.fenixsoft.jvm.chapter7;

/**
 * 非主动使用类字段演示
 **/
public class NotInitialization_1 {
    static {
        System.out.println("NotInitialization_1 init!");
    }

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }

}
