public class StaticBinding {
    static class A {
        private int fa = 1;
        private void mPrivate() {
            System.out.println("APrivate");
        }

        void mInherit() {
            System.out.println("AInherit");
        }

        void mNoInherit() {
            System.out.println("ANoInherit");

        }

        static void mStatic() {
            System.out.println("AStatic");
        }
    }

    static class B extends A {
        private void mPrivate() {
            System.out.println("BPrivate");
        }

        @Override
        void mInherit() {
            System.out.println("BInherit");

        }

        static void mStatic() {
            System.out.println("BStatic");
        }
    }

    public static void main(String[] args) {
        B b = new B();
        b.mPrivate();
        b.mInherit();
        b.mNoInherit();
        b.mStatic();
        System.out.println();

        A a =  b;
        a.mPrivate();
        a.mInherit();
        a.mNoInherit();
        a.mStatic();
        System.out.println(a.fa);
    }
}
