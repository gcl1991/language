package org.fenixsoft.jvm.chapter7;

/**
 * 非主动使用类字段演示
 **/
public class NotInitialization_3 {
    static {
        System.out.println("NotInitialization_3 init!");
    }

    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}
