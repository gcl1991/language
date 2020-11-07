public class NameTest {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(String.class);
        System.out.println(String.class.toString());
        System.out.println(String.class.getName());
        System.out.println("".getClass().getName());
        System.out.println(Class.forName("java.lang.String").getName());
        System.out.println(Double[].class.getName());
        Object b =new B();
        System.out.println(b.getClass().getName());
        System.out.println(C.C1.getClass().getName());
        System.out.println(C.class.getName());
        System.out.println(C.class.getClass().getName());
    }
}
