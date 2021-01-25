package general;

import java.util.*;

// for-each 循环优于传统 for 循环
// 传统for循环适用于（可以删改元素）：有损过滤，转换，并行迭代
// 其他使用for-each循环（只能读取元素）
public class th58 {
    public static void preferForEach(){
        // 对比说明for-each的优势，减少出错机会，可读性强
        List<String> elements = Arrays.asList("a", "classes");
        // Not the best way to iterate over a collection!
        // 这不是迭代集合的最佳方法！
        for (Iterator<String> i = elements.iterator(); i.hasNext(); ) {
            String e = i.next();
            // 迭代器在每个循环中出现三次
            // Do something with e
        }

        String[] a = {"a", "classes"};
        // Not the best way to iterate over an array!
        // 并不是迭代数组的最佳方法
        for (int i = 0; i < a.length; i++) {
            // Do something with a[i]
            // 索引变量在每个循环中出现四次
        }

        // The preferred idiom for iterating over collections and arrays
        // 遍历集合和数组的首选习惯用法
        for (String e : elements) {
            // Do something with e
        }

    }

    enum Face { ONE, TWO, THREE, FOUR, FIVE, SIX }

    public static void bug() {
        // 说明传统for循环容易隐藏的bug
        // Same bug, different symptom!只打印6次，而不是36次
        Collection<Face> faces = EnumSet.allOf(Face.class);
        for (Iterator<Face> i = faces.iterator(); i.hasNext(); ) {
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); ) {
                System.out.println(i.next() + " " + j.next());
            }
        }

        // Fixed, but ugly - you can do better!
        // 修正方法1，但难看-您可以做得更好
        for (Iterator<Face> i = faces.iterator(); i.hasNext(); ) {
            Face suit = i.next();
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); ) {
                System.out.println(suit + " " + j.next());
            }
        }

        // Preferred idiom for nested iteration on collections and arrays
        // 修正方法2，优雅-集合和数组上嵌套迭代的首选惯用法
        for (Face suit : faces) {
            for (Face rank : faces) {
                System.out.println(suit + " " + rank);
            }
        }
    }

    public static void main(String[] args) {
        bug();
    }
}
