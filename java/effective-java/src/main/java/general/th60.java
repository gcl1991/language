package general;


import java.math.BigDecimal;

// 若需要精确答案就应避免使用float和double类型
// 1 float和double类型特别不适合进行货币计算，因为不可能将0.1（或10的任意负次幂）精确地表示为float或double。
// 2 不介意不使用基本类型带来的不便和成本，请使用BigDecimal,其可以控制舍入模式
// 3 注重性能，如果数值不超过9位小数，可以使用int；如果不超过18位，可以使用long。如果数量可能超过18位，则使用BigDecimal。
public class th60 {
    public static void main(String[] args) {
        brokenMonetary();
        fixed1();
        fixed2();
    }
    public static void brokenMonetary() {
        // Broken - uses floating point for monetary calculation!
        // 损坏-使用浮点数进行货币计算
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $ " + funds);
    }

    public static void fixed1() {
        // 修复方法1：它与原始算术类型相比很不方便，而且速度要慢得多
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Money left over: $" + funds);
    }

    public static void fixed2() {
        // 修复方法2：使用int或long进行等价计算
        // 100美分等于1美元
        int itemsBought = 0;
        int funds = 100;
        for (int price = 10; funds >= price; price += 10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Cash left over: $" + funds + " cents");
    }

}
