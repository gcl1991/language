package general;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

// 接口优于反射
// 缺点：1 无法进行编译时类型检查，2 代码冗长(异常处理繁琐，类型转换不安全)，3 性能低
// 使用场景：需要在编译时处理未知的类
public class th65 {
    public static class ReflectiveInstantiation {
        // Reflective instantiation with interface access
        // 具有接口访问的反射式实例化
        public static void main(String[] args) {
            // Translate the class name into a Class object
            Class<? extends Set<String>> cl = null;
            try {
                cl = (Class<? extends Set<String>>)  // Unchecked cast!
                        Class.forName(args[0]);
            } catch (ClassNotFoundException e) {
                fatalError("Class not found.");
            }

            // Get the constructor
            Constructor<? extends Set<String>> cons = null;
            try {
                cons = cl.getDeclaredConstructor();
            } catch (NoSuchMethodException e) {
                fatalError("No parameterless constructor");
            }

            // Instantiate the set
            Set<String> s = null;
            try {
                s = cons.newInstance();
            } catch (IllegalAccessException e) {
                fatalError("Constructor not accessible");
            } catch (InstantiationException e) {
                fatalError("Class not instantiable.");
            } catch (InvocationTargetException e) {
                fatalError("Constructor threw " + e.getCause());
            } catch (ClassCastException e) {
                fatalError("Class doesn't implement Set");
            }

            // Exercise the set
            s.addAll(Arrays.asList(args).subList(1, args.length));
            System.out.println(s);
        }

        private static void fatalError(String msg) {
            System.err.println(msg);
            System.exit(1);
        }
    }
}
