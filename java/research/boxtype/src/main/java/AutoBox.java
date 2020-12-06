/**
 * 考察何时自动拆箱装箱问题.
 * */
public class AutoBox {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        // Integer+Integer将会自动拆箱为int后运算
        // Integer == int时候将会把Integer拆箱
        // 所以相等
        System.out.println(c == (a + b));
        // Integer.equals(int)将会把int自动装箱
        // equals比较逻辑关系, 所以相等
        System.out.println(c.equals(a + b));
        // ==只在遇到算数运算情况下才会自动拆箱
        // ==比较是否为同一对象, 不相等
        System.out.println(c == (Integer) (a+b));
    }
}
