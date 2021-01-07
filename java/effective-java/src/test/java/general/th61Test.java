package general;

import org.junit.Test;
import static org.junit.Assert.*;

public class th61Test {
    @Test
    public void testBrokenComparator(){
        int result = th61.brokenComparator(new Integer(42),new Integer(42));
        assertEquals(result,1);
    }

    @Test(expected = NullPointerException.class)
    public void testMixIntInteger(){
        th61.mixIntInteger();
    }

    @Test
    public void testPerformance(){
        long start = System.nanoTime();
        th61.performance();
        long now = System.nanoTime();
        System.out.println("time:"+(now-start)/1000_000+"ms");
    }
}
