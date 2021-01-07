package general;


import java.util.Comparator;

// 基本数据类型优于包装类
// 区别：1 包装类型实例可以具有相同的值和不同的标识 2包装类型定义域多一个null。3 包装类型更浪费空间
// 只要有选择，就应该优先使用基本类型，而不是包装类型
public class th61 {
    public static int brokenComparator(Integer i,Integer j){
        // Broken comparator - can you spot the flaw?
        // 验证区别1：将==操作符应用于包装类型几乎都是错误的。
        return (i < j) ? -1 : (i == j ? 0 : 1);
    }

    static Integer i;
    public static void mixIntInteger() {
        // 验证区别2：空对象引用自动拆箱，将得到一个 NullPointerException
        if (i == 42)
            System.out.println("Unbelievable");
    }

    // Hideously slow program! Can you spot the object creation?
    // 验证区别3
    public static void performance() {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
