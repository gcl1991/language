package lambdasinaction.chap9;

public class Rule2 {
    public static void main(String... args) {
        new C().hello();
    }

    static interface A{
        public default void hello() {
            System.out.println("Hello from A");
        }
    }

    static interface B extends A {
        public default void hello() {
            System.out.println("Hello from B");
        }
    }

    static abstract class D implements A{
//        public abstract void hello();
    }

    static class C extends D implements B, A {
    }
    // D中并未实现相应方法，所以依然使用B中方法
    // 如果在类D中定义抽象方法hello,但是类C必须被声明为抽象，或者必须在D中实现抽象方法hello
}
