import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;

/**
 * 研究注解的实现
 * */
@Retention(RetentionPolicy.RUNTIME)
@interface Fruit {
    String name() default "";
}

@Fruit(name = "Apple")
public class Implement {
    public static void main(String[] args) throws Exception{
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Fruit fruit = Implement.class.getAnnotation(Fruit.class);
        InvocationHandler h = Proxy.getInvocationHandler(fruit);
        Field f = h.getClass().getDeclaredField("memberValues");
        f.setAccessible(true);
        Map<String,String> memberValues = (Map<String,String>) f.get(h);

        System.out.println(Fruit.class); // 说明注解本质是接口
        System.out.println(fruit.getClass().getName()); //说明Runtime注解代理类继承了Proxy
        System.out.println(Arrays.deepToString(fruit.getClass().getGenericInterfaces())); // 说明Runtime注解代理类实现了注解接口
        System.out.println(h.getClass()); // 说明真正的实现类为sun.reflect.annotation.AnnotationInvocationHandler
        System.out.println(fruit.name()); // 说明注解通过方法存储数据（因为接口中字段只能为常量public static final）
        for(Map.Entry<String,String> entry:memberValues.entrySet()){
            System.out.println(entry); // 说明注解的值存储在InvocationHandler的memberValues(Map<String,String>)中
        }


    }
}
