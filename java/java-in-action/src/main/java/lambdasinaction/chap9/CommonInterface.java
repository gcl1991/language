package lambdasinaction.chap9;

public class CommonInterface {
    public static void main(String... args) {
        new C().hello();
    }

    interface A{
        Number hello();
    }

     interface B {
        Integer hello();
    }

    static class C implements B, A {
        public Integer hello(){
            return 0;
        }
    }
    // 对于普通接口，必须实现接口B中的方法
    // 返回类型必须兼容，否则会提示冲突：尝试使用不兼容的返回类型，必须返回Integer
}
