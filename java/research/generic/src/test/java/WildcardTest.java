import org.junit.Test;

public class WildcardTest {

    @Test
    public void test(){
        // 只能使用Integer类型
        Wildcard.m1(new Wildcard.A<Integer>());

        // 可以使用任何类型
        Wildcard.m2(new Wildcard.A<Double>());
        Wildcard.m2(new Wildcard.A<String>());

        // 只能使用Comparable子类
        Wildcard.m3(new Wildcard.A<Double>());
        Wildcard.m3(new Wildcard.A<String>());

        // 只能使用Comparable父类
        Wildcard.m4(new Wildcard.A<Object>());

        // 可以使用任何类型但是需要提供类型信息
        Wildcard.m5(new Wildcard.A<Double>());
        Wildcard.m5(new Wildcard.A<String>());

        // 只能使用Object类型
        Wildcard.m6(new Wildcard.A<Object>());
    }
}
