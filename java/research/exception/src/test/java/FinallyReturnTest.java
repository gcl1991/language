import org.junit.Test;

public class FinallyReturnTest {
    @Test
    public void testReturnOrder() {
        FinallyReturn.returnOrder(true);
        FinallyReturn.returnOrder(false);
    }
}
