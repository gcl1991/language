package general;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;

/**
 * 了解并使用库:优先寻找高质量的第三方库
 * 优点：正确性，性能和功能会不断提高，易于阅读维护重用
 * 需要掌握的库：java.lang,java.util,java.io,Collections框架,Streams库,java.util.concurrent
 */
public class th59 {
    // Common but deeply flawed!
    static Random rnd = new Random();

    // 演示自己实现Random算法存在bug
    static int random(int n) {
        // 缺陷1，如果 n 是小的平方数，随机数序列会在相当短的时间内重复。
        // 缺陷2，如果 n 不是 2 的幂，那么平均而言，一些数字将比其他数字更频繁地返回。
        // 缺陷3，在极少数情况下会返回超出指定范围的数字，这是灾难性的结果。
        return Math.abs(rnd.nextInt()) % n;
    }
    static void testCustomRandomMethodBug(){
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n) < n / 2) {
                low++;
            }
        }
        // 缺陷1和2
        System.out.println(low);
        // 缺陷3
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));

    }

    public static void java9FreeMethod() {
        // 说明JAVA9提供的免费方法
        // Printing the contents of a URL with transferTo, added in Java 9
        // 使用Java 9中添加的具有transferTo的方式打印URL的内容
        String url = "https://docs.oracle.com/javase/9/docs/api/java/io/InputStream.html";
        try (InputStream in = new URL(url).openStream()) {
            in.transferTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
