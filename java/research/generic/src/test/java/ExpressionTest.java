import org.junit.Test;

public class ExpressionTest {
    @Test
    public void testMethod(){
        Expression<Integer> interval = new Expression<>(1,2);
        Integer x = interval.getLower();
        Integer y = interval.upper;
    }

}
