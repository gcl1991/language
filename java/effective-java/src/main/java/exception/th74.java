package exception;

// 每个方法抛出的异常都需要创建文档
public class th74 {
    // 1 只有main方法它可以被安全地声明抛出Exception
    public static void main(String[] args) throws Exception {
        a(0);
    }

    // 3 A调用B,A中要处理或建立B导致的受查异常（可控异违反开闭原则）
    // A中不必处理或为B可能抛出的不可控异常建立文档和说明(A应当通过参数检查避免B中的不可控异常:避免/记录/转译)。
    /**
     * @throws CheckedException1 method b throws
     * */
    static void a(int x) throws CheckedException1 {
        b(x);
    }

    // 2 始终要单独地声明受检/未受检异常,方法的声明中throws关键字只包含受检异常，以区分受检和非受检异常。
    /**
     * @throws CheckedException1        if x >100
     * @throws IllegalArgumentException if x < 0
     */
    static void b(int x) throws CheckedException1 {
        if (x == 1) {
            throw new UncheckException1();
        }
        if (x == 2) {
            throw new CheckedException1();
        }
    }

    // 4 如果一个类中的许多方法出于同样的原因而抛出同一个异常，在该类的文档注释中对这个异常建立文档，这是可以接受的
    static class CheckedException1 extends Exception {

    }

    static class UncheckException1 extends RuntimeException {

    }
}
