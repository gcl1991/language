public class ATest {

    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        A.B bb = a.new B(2);
        b.m();
    }
}
