/**
 * 用于观察局部变量和成员变量final字段javac后差异.
 *
 * 数据流及控制流分析阶段
 */
public class FinalVerify {
    /**
     * 成员变量final字段javac后将保留
     * */
    final int x = 0;

    public static void main(String[] args) {
        method(0);
    }

    /**
     * 局部变量final字段经过javac之后将被消除.
     * */
    public static void method(final int y) {
        final int z = 0;
        System.out.println(z);
    }
}
