import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class H<T> implements InvocationHandler {
    private T object;

    H(T o) {
        object = o;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }
}
