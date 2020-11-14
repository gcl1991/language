public class AutoBox {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d); // 相等
        System.out.println(e == f); // 不相等
        System.out.println(c == (a+b)); // 相等
        System.out.println(c.equals(a+b)); // 相等
        System.out.println(g==(a+b)); // 相等
        System.out.println(g.equals(a+b)); // 不相等

    }
}
