public class Extends {
    // T extends A<T> 将限制T为A的子类，以避免定义死循环
    public static class A <T extends A<T>> {
        T a;
        A(){}
        A(T x){
            a = x;
        }

        void print(){
            System.out.println(a);
        }
    }

    public static class B extends A<B> {
    }

    public static class C{}

    public static class D <T extends C>{

    }
}
