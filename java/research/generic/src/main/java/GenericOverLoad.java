import java.util.ArrayList;
import java.util.List;

/**
 * 观察泛型方法重载.
 *
 * 此代码需要使用JDK6进行编译,运行可以使用JDK8
 * */
public class GenericOverLoad {
    public static String method(List<String> list){
        System.out.println("invoke List<String>");
        return "";
    }
    public static int method(List<Integer> list){
        System.out.println("invoke List<Integer>");
        return 0;
    }

    public static void main(String[] args) {
        // 调用List<String>方法
        method(new ArrayList<String>());
        // 调用List<Integer>方法
        method(new ArrayList<Integer>());
    }
}
