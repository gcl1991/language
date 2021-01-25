package general;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 最小化局部变量的作用域
 * 1 在首次使用的地方声明它,容易发现，且利于GC
 * 2 最小化局部变量作用域的最终技术是保持方法小而集中，每个行为对应一个方法
 * */
public class th57 {
    public static void preferIdiom(){
        // 演示遍历的首选方法
        List<String> c = Arrays.asList("a", "classes","c");
        // Preferred idiom for iterating over a collection or array
        // 循环习惯用法1：遍历集合或数组的首选惯用法
        for (String e : c) {
            // Do Something with e
        }

        // Preferred Idiom for iterating when you need the iterator
        // 循环习惯用法2：在需要迭代器时进行迭代的首选惯用语
        for (Iterator<String> i = c.iterator(); i.hasNext(); ) {
            String e = i.next();
            // Do something with e and i
        }

        // 循环习惯用法3：避免了每次迭代中冗余计算的代价
        for (int i = 0, n = expensiveComputation(); i < n; i++) {
            // Do something with i;
        }

    }
    public static void bug(){
        // 演示while相对于for更容易隐藏bug
        List<String> c = Arrays.asList("a", "classes","c");
        Iterator<String> i = c.iterator();
        while (i.hasNext()) {
            // Do something with e and i
        }

        Iterator<String> i2 = c.iterator();
        while (i.hasNext()) { // BUG!
            // Do something with e and i
        }

        for (Iterator<String> i3 = c.iterator(); i3.hasNext(); ) {
            String e = i3.next();
            // Do something with e and i
        }

        List<String> c4 = Arrays.asList("a", "classes","c");
        // Compile-time error - cannot find symbol i
        for (Iterator<String> i4 = c4.iterator(); i3.hasNext(); ) {
            String e2 = i4.next();
            // Do something with e2 and i2
        }

    }
}
