public class A {
    boolean x =false;

    public class B {
        B() {

        }

        B(int x) {
        }
        void m(){}
    }
    static class D{}

    void m() {
        class B {}
        class C {}
        class E {}
        D d = new D(){};
        D f = new D(){};
    }
    void mm(){
        class C {}
        class E {}
        class F {}
        D d = new D(){};
        D f = new D(){};

    }
}
