public class OverLoading {
    static class A{}
    static class B extends A{}
    void m(A a){
        System.out.println("mA");
    }

    void m(B b){
        System.out.println("mB");
    }

    public static void main(String[] args) {
        OverLoading staticBinding = new OverLoading();
        A a = new A();
        B b = new B();
        staticBinding.m(a);
        staticBinding.m(b);
        staticBinding.m((A) b);
    }
}
