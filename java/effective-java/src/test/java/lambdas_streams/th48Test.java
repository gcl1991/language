package lambdas_streams;

import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class th48Test {

    @Test
    public void testSerial(){
        th48.piSerial(50);
    }

    @Test
    public void testParallel(){
        th48.piParallel(50);
    }

}
