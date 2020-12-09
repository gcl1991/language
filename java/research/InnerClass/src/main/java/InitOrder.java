/**
 * 研究静态嵌套类类初始化顺序
 */
public class InitOrder {
    static int x = 0;

    static {
        System.out.println("外部类静态<clinit>初始化");
    }

    public static class Inner {
        static {
            System.out.println("内部静态类静态初始化<clinit>");
        }
        public static void m(){
            System.out.println(x);
        }
    }
}
