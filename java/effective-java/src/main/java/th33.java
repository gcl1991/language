import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.*;

public class th33 {
    public static void main(String[] args) {
        // <1>
        Favorites f = new Favorites();
        f.put(String.class,"123");
        f.put(Integer.class,"123"); // 类型不匹配不可插入
        System.out.println(f.get(String.class));

        // <2>
        HashSet<String> hString = new HashSet<>();
        hString.add("123");
        HashSet<Integer> hInteger = new HashSet<>();
        hInteger.add(1);
        f.put(HashSet.class,hString); // 原始类型插入
        f.put(HashSet.class,hInteger); // 原始类型插入
        f.put(HashSet<String>.class,hs); // error 不可插入泛型类
        System.out.println(f.get(HashSet.class));


        // <3>
        f.put(String[].class, new String[]{"1", "2"}); // 可插入数组
        System.out.println(Arrays.toString(f.get(String[].class)));

        // <4>
        System.out.println(Deprecated.class);
        System.out.println(getAnnotation(A.class,"java.lang.Deprecated"));
    }
    static class Favorites{
        private Map<Class<?>,Object> favorites = new HashMap<>();
        public <T> void put(Class<T> type, T instance){
            favorites.put(Objects.requireNonNull(type),instance);
        }
        // type.cast()是不必要的
        public <T> void putCast(Class<T> type, T instance){
            favorites.put(Objects.requireNonNull(type),type.cast(instance));
        }

        public <T> T get(Class<T> type){
            return type.cast(favorites.get(type));
        }
     }

     static Annotation getAnnotation(AnnotatedElement element,String name){
        Class<?> at = null;
        try {
            at = Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        return element.getAnnotation(at.asSubclass(Annotation.class));
     }

     @Deprecated
     static class A{}
}
