package objects.method;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class th14Test {
    BigDecimal b1 ;
    BigDecimal b2 ;
    @Before
    public void setup(){
        b1 = new BigDecimal("1.0");
        b2 = new BigDecimal("1.00");
    }
    // 测试BigDecimal的equals和compare不一致行为
    @Test
    public void testBigDecimalConsistent(){
        assertFalse(b1.equals(b2));
        assertEquals(b1.compareTo(b2),0);

    }

    // 测试HashSet和TreeSet的不一致比较方式
    @Test
    public void testHashTreeSetConsistent(){
        Set<BigDecimal> r1 = new TreeSet<>();
        Set<BigDecimal> r2 = new HashSet<>();
        r1.add(b1);
        r1.add(b2);
        r2.add(b1);
        r2.add(b2);
        assertEquals(r1.size(),1);
        assertEquals(r1.toString(),"[1.0]");
        assertEquals(r2.size(),2);
        assertEquals(r2.toString(),"[1.0, 1.00]");
    }
}
