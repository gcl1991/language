package lambdasinaction.chap9;

public class Rule1 {
    public static void main(String... args) {
        new C().hello();
    }

    static interface A{
        public default void hello() {
            System.out.println("Hello from A");
        }
    }

    static interface B {
        public default void hello() {
            System.out.println("Hello from B");
        }
    }

    static class E{
        public void hello(){
            System.out.println("Hello from E");
        }
    }

    static class D extends E{
    }

    static class C extends D implements B, A {
    }
    // 如果类型不兼容会提示，类E中的hello无法实现接口B中的hello，返回类型不兼容
    // 也就是说对于规则1，是通过继承父类的方法来作为接口方法的实现
}
