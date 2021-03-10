import org.junit.Test;

import java.lang.reflect.Method;

public class InheritedClassTest {
    @Test // 子类可以继承父类注解，子类方法无法继承父类方法注解
    public void testClass() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> a = Class.forName("A");
        Class<?> a1= Class.forName("A1");
        System.out.println(a.getAnnotations().length);
        System.out.println(a1.getAnnotations().length);
        Method m = a.getMethod("m");
        Method m1 = a1.getMethod("m");
        System.out.println(m.getAnnotations().length);
        System.out.println(m1.getAnnotations().length);
    }

    @Test // 子类无法继承父接口注解,子接口也无法继承父接口注解,子类方法无法继承父类方法注解
    public void testInterface() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> b = Class.forName("B");
        Class<?> b1= Class.forName("B1");
        Class<?> b2= Class.forName("B2");
        System.out.println(b.getAnnotations().length);
        System.out.println(b1.getAnnotations().length);
        System.out.println(b2.getAnnotations().length);
        Method m = b.getMethod("m");
        Method m1 = b1.getMethod("m");
        Method m2 = b1.getMethod("m");
        System.out.println(m.getAnnotations().length);
        System.out.println(m1.getAnnotations().length);
        System.out.println(m2.getAnnotations().length);
    }
}
