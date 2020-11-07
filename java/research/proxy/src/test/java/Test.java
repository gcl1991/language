import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        InvocationHandler handler  = new H(new A());
        Object proxy= Proxy.newProxyInstance(B.class.getClassLoader(),new Class[] {Comparable.class},handler);
        Comparable a = (Comparable) proxy;
        a.compareTo(null);
        a.toString();
        Class p2 = proxy.getClass();
        Method[] methods = p2.getMethods();
        Class[] c2 = p2.getInterfaces();
        System.out.println(p2.getSuperclass());
        System.out.println();
        for(Method m:methods){
            System.out.println(m);
        }
        System.out.println();
        Method[] ms2=p2.getDeclaredMethods();
        for(Method m:ms2){
            System.out.println(m);
        }
        System.out.println();
        for (Class c:c2){
            System.out.println(c);
        }
    }
}
