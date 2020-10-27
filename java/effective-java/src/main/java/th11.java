import java.util.HashMap;
import java.util.Map;
import static java.lang.Integer.*;
public class th11 {
    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        PhoneNumber x1 = new PhoneNumber("01");
        PhoneNumber x2 = new PhoneNumber("01");
        m.put(x1, "my is 01");
        System.out.println(m.get(x2)); // is null
        System.out.println(x1==x2); // false
        System.out.println(x1.equals(x2)); // true
        informationLost();
    }
    private static void informationLost(){
        int origin = 20_0000_0000; // 20亿
        System.out.println(origin * 3 * inv(3)); // 结果=20亿
        System.out.println(origin * 4 * inv(4)); // 结果=0
        System.out.println(issue1(3)); // 1
    }

    private static int inv(int x){
        return MAX_VALUE/x-MAX_VALUE;
    }
    private static int issue1(int x){
        return MAX_VALUE-x*(MAX_VALUE/x);
    }

    private static void bitOperation(){
        System.out.println(2_147_483_647);
        System.out.println(2_147_483_647<<1); // -2 算数左移，覆盖符号位
        System.out.println(2_147_483_647>>1); // 1073741823 算数右移，高位填充0
        System.out.println(2_147_483_647>>>1); // 1073741823 逻辑右移，高位填充0
        System.out.println(2_147_483_647+1); //-2147483648
        System.out.println(-2_147_483_648);
        System.out.println(-2_147_483_648<<1); // 0 算数左移 覆盖符号位
        System.out.println(-2_147_483_648>>1); // -1073741824 算数右移，高位填充1
        System.out.println(-2_147_483_648>>>1); // 1073741824 逻辑右移，高位填充0
        System.out.println(-2_147_483_648-1); //2147483647
    }

    public static class PhoneNumber {
        private String string;

        public PhoneNumber(String string) {
            this.string = string;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof PhoneNumber)) return false;
            PhoneNumber pn = (PhoneNumber) o;
            return pn.string.equals(string);
        }
    }
}
