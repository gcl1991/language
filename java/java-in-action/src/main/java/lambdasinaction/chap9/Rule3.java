package lambdasinaction.chap9;

public class Rule3 {
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

    static interface D{
        default Integer getNumber(){
            System.out.println("D");
            return 0;
        }
    }
    static interface E{
        default Number getNumber(){
            System.out.println("E");
            return 0;
        }
    }

    static class C implements B, A,E,D {
        public void hello(){
            B.super.hello();
        }

        public Integer getNumber(){
            return 0;
        }
    }
    // 会提示C从B和A类型继承hello的不相关默认方法。
    // 必须显式解决冲突
    // 返回类型为协变时，应使用子类返回类型，否则会类型不兼容，即不能使用Number，而要使用Integer，否则会提示C中的getNumber与D中的getNumber相冲突,尝试使用不兼容的返回类型
}
