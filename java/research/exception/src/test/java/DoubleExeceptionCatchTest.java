import org.junit.Test;

public class DoubleExeceptionCatchTest {
    @Test
    public void testDoubleCatch(){
        DoubleExeceptionCatch.doubleCatch(true);
    }

    @Test
    public void testCatchThrow(){
        DoubleExeceptionCatch.catchThrow(true);
    }
}
