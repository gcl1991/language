package serialization.th87;

import org.junit.Test;
import serialization.*;

public class th89Test {
    @Test
    public void tesSingleton(){
        // 测试序列化如何破坏单例
        String filename = "elvis.ser";
        Serials.write(filename, th89.Elvis.INSTANCE);
        th89.Elvis elvis = Serials.read(filename);
        System.out.println("反序列化前对象:"+th89.Elvis.INSTANCE);
        System.out.println("反序列化后对象:"+elvis);
    }

    @Test
    public void testNonTransient(){
        // Initializes ElvisStealer.impersonator and returns
        // the real Elvis (which is Elvis.INSTANCE)
        // 初始化ElvisStealer。模拟并返回真正的Elvis(即Elvis. instance)
        String filenameReal = "elvis.ser";
        String filenameFake = "elvisStealer.ser";
        Serials.write(filenameFake, th89.ElvisStealer.impersonator);
        th89.Elvis elvis = (th89.Elvis) Serials.read(filenameReal);
        th89.Elvis impersonator = th89.ElvisStealer.impersonator;
        elvis.printFavorites();
        impersonator.printFavorites();
    }

    @Test(expected = java.lang.ClassCastException.class)
    public void tesAccessibility(){
        // 测试继承过程中，子类未覆盖readResolve,将会抛出异常,因为父类实例无法转成子类实例
        String filename = "elvisSub.ser";
        Serials.write(filename, new th89.ElvisSub());
        th89.ElvisSub elvis = Serials.read(filename);
        System.out.println("反序列化后对象:"+elvis);
    }

    @Test
    public void tesSingletonEnum(){
        // 测试序列化如何破坏单例
        String filename = "elvisEnum.ser";
        Serials.write(filename, th89.ElvisEnum.INSTANCE);
        th89.ElvisEnum elvis = Serials.read(filename);
        System.out.println("反序列化前对象:"+th89.ElvisEnum.INSTANCE);
        System.out.println("反序列化后对象:"+elvis);
    }
}
