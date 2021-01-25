package classes;

import org.junit.Test;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class th19Test {
    // 演示自用性的缺点
    @Test
    public void testExtends1() {
        th19.Son1<String> s = new th19.Son1<>();
        s.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }

    // 演示使用帮助函数消除自用性
    @Test
    public void testExtends2() {
        th19.Son2<String> s = new th19.Son2<>();
        s.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }


    // 测试说明不应在构造器中调用可受保护的方法
    @Test
    public void testExtern() {
        th19.Sub sub = new th19.Sub();
        sub.overrideMe();
    }

    // 演示Object的clone方法的浅克隆
    @Test
    public void testClone() throws CloneNotSupportedException {
        th19.CloneDemo c = new th19.CloneDemo();
        th19.CloneDemo cc = c.clone();
        System.out.println(c);

        c.intF = 20; // ok
        c.stringF = "b"; // ok
        c.intArray[0] = 0; // 无法克隆数组对象
        c.integerF = 30; // ok
        c.dateF.setDate(2023); // 无法克隆可变对象
        System.out.println(c);
        System.out.println(cc);
    }
}
