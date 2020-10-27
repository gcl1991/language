package lambdasinaction.chap9;

public class Diamond{

    public static void main(String...args){
        new D1().hello();
        new D2().hello();
    }

    static interface A{
        public default void hello(){
            System.out.println("Hello from A");
        }
    }

    static interface B1 extends A { }

    static interface C1 extends A {
    }

    static class D1 implements B1, C1 {
    }

    static interface B2 extends A {
        public default void hello(){
            System.out.println("Hello from BB");
        }

    }

    static interface C2 extends A {
        void hello();
    }

    static class D2 implements B2, C2 {
        public void hello(){

        }
    }
    //类D2必须实现C2中的hello方法,此时根据规则2，C2中hello更具体(普通接口抽象方法优先级高于默认方法)
}
