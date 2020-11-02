import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        B b = new B();
        Method m = B.class.getMethod("publicB");
        m.invoke(b);
    }
}
