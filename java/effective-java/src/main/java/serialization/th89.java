package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * 对于实例控制, 枚举类型优于readResolve
 * 序列化：可以通过在readResolve中使用非transient实现序列化对象替换,破坏单例
 * 枚举：无此风险，为什么？如何实现？
 */
public class th89 {
    // 破碎的单例-具有非瞬态对象参考字段！
    // Broken singleton - has nontransient object reference field!
    public static class Elvis implements Serializable {
        public static final Elvis INSTANCE = new Elvis();
        private String[] favoriteSongs =  { "Hound Dog", "Heartbreak Hotel" };

        // 应该设置为private，此处为了演示后续继承问题，设置为包私有
        Elvis() {
        }

        public void printFavorites() {
            System.out.println(Arrays.toString(favoriteSongs));
        }

        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            System.out.println("readObject："+this);
        }

        // readResolve在readObject后调用
        // readResolve for instance control - you can do better!
        public Object readResolve() {
            // Return the one true Elvis and let the garbage collector
            // take care of the Elvis impersonator.
            // 返回一个真正的Elvis，并让垃圾收集器处理Elvis模仿者。
            return INSTANCE;
        }
    }
    public static class ElvisSub extends Elvis{

    }
    /**
     * 企图使用非transient实现序列化对象替换
     * 未能复现
     * */
    public static class ElvisStealer implements Serializable {
        // 冒名顶替者
        public static Elvis impersonator;
        private static final long serialVersionUID = 0;
        // 有效载荷
        private Elvis payload;
        private Object readResolve() {
            // Save a reference to the "unresolved" Elvis instance
            // 保存对“未解析的”Elvis实例的引用
            impersonator = payload;
            // Return object of correct type for favoriteSongs field
            // 为favoriteSongs字段返回正确类型的对象
            return new String[] { "A Fool Such as I" };
        }
    }
    // Enum singleton - the preferred approach
    public enum ElvisEnum {
        INSTANCE;
        private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };
        public void printFavorites() {
            System.out.println(Arrays.toString(favoriteSongs));
        }
    }
}
