// 多继承菱形继承问题
// 类优先/接口优先/同级同签名默认方法与默认方法冲突OR同级默认方法与抽象方法冲突 必须手动解决
public class Multiple {
    interface A{
        default void mA(){
            System.out.println("mA");
        }
    }
    interface B extends A{
        @Override
        default void mA(){
            System.out.println("mB");
        }
    }
    interface C extends B{
        @Override
        void mA();
    }
    static class D implements C,B{
        public static void main(String[] args) {
            new D().mA();
        }

        @Override
        public void mA() {

        }
    }
}
