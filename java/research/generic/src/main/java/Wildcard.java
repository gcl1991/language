public class Wildcard {
    public static class A<T>{}
    public static void m1(A<Integer> a){

    }

    public static void m2(A<?> a){

    }

    public static void m3(A<? extends Comparable<?>> a){

    }

    public static void m4(A<? super Comparable<?>> a){

    }

    public static <T> void m5(A<T> a){

    }

    public static void m6(A<Object> a){}
}
