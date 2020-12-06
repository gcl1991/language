/**
 * 用于观测变量初始化顺序.
 *
 * 观察javac对变量初始化重排过程
 */
public class VariableInitializationOrder {
    int a=1;
    {
        // 此变量b非成员变量,作用域在此代码块中,外部无法访问,经过javac后b将被删除
        int b;
        a = 2;
    }
    static {
        // 此变量d非静态变量,作用域在此代码块中,外部无法访问
        int d;
        c = 1;
    }
    static int c=3;

    /**
     * 变量初始化顺序.
     *
     * 无论源码中变量声明和代码块顺序如何
     * 都先执行声明，再按源码中赋值操作对变量进行赋值
     * 对于clinit:c=0 c=1 c=3 最终 c=3
     * 对于init:a=0 a=1 a=2 最终 a=2
     * */
    public static void main(String[] args) {
        VariableInitializationOrder v = new VariableInitializationOrder();
        System.out.println(v.a);
        System.out.println(v.c);
    }
}
