package general;

import java.util.HashMap;
import java.util.Map;

// 当使用其他类型更合适时应避免使用字符串
// 1 字符串不应代替值类/枚举类/聚合类型：值类型应该使用对象来表示，而不是字符串。
// 2 字符串不能很好地替代capabilities
public class th62 {
    // Broken - inappropriate use of string as capability!
    // 损坏-不当使用字符串作为标识
    // 问题1：字符串键表示线程本地变量的共享全局名称空间，安全性很差
    public static class ThreadLocal {
        private static final Map<String,Object> capabilities = new HashMap<>();
        private ThreadLocal() { } // Noninstantiable 不可实例化
        // Sets the current thread's value for the named variable.
        // 为命名变量设置当前线程的值。
        public static void set(String key, Object value){
            capabilities.put(key,value);
        };
        // Returns the current thread's value for the named variable.
        // 返回指定变量的当前线程值。
        public static Object get(String key){
            return capabilities.get(key);
        }
    }

    // 改进1：消除安全性问题
    public static class ThreadLocal2 {
        private static final Map<Key,Object> capabilities = new HashMap<>();
        private ThreadLocal2() { } // Noninstantiable
        public static class Key { // (Capability)
            Key() {

            }
        }
        // Generates a unique, unforgeable/不可伪造 key
        public static Key getKey() {
            return new Key();
        }
        public static void set(Key key, Object value){
            capabilities.put(key,value);
        };
        public static Object get(Key key){
            return capabilities.get(key);
        };
    }
    // 改进2：消除内部类
    public final static class ThreadLocal3 {
        private Object value;
        public ThreadLocal3(){};
        public void set(Object value){
            this.value = value;
        };
        public Object get(){
            return value;
        }
    }
    // 改进3：变为类型安全
    public final static class ThreadLocal4<T> {
        public ThreadLocal4(){};
        public void set(T value){};
        public T get(){
            return (T) this;
        }
    }
}
