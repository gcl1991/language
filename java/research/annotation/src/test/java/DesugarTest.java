import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

// 注解是自动继承Annotation接口的接口，注解接口所有的方法都是抽象的
// 注解接口由代理自动实现，以通过方法获取注解中的值。
@Desugar
public class DesugarTest {
    @Test
    public void test(){
        Desugar desugar = DesugarTest.class.getAnnotation(Desugar.class);
        Class<?> c = desugar.getClass();
        InvocationHandler handler = Proxy.getInvocationHandler(desugar);
        System.out.println("父类: "+c.getSuperclass());
        System.out.println("实现接口: "+Arrays.toString(c.getInterfaces()));
        System.out.println("构造器: "+Arrays.toString(c.getConstructors()));
        for (Method m:c.getMethods()){
            System.out.println(m);
        }

        System.out.println();
        for (Field f:handler.getClass().getDeclaredFields()){
            System.out.println(f);
        }
    }
}
