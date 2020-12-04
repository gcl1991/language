import org.junit.Test;

public class FinallyReturnTest {
    @Test
    public void testReturnOrder() {
        System.out.println(FinallyReturn.returnOrder(true));
        System.out.println(FinallyReturn.returnOrder(false));
    }
}
