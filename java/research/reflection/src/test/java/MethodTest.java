import java.lang.reflect.Array;
import java.lang.reflect.Method;

public class MethodTest {
    public static void main(String[] args) {
        Method[] ms = B.class.getDeclaredMethods();
        for(Method m:ms){
            System.out.println(m);
        }
        System.out.println();

        Method[] ms2 = B.class.getMethods();
        for(Method m:ms2){
            System.out.println(m);
        }
        System.out.println();
        Method[] ms3 = B.class.getSuperclass().getMethods();
        for (Method m : ms3) {
            System.out.println(m);
        }
    }
}
