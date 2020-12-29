package serialization.th87;

import org.junit.Test;
import serialization.Serials;
import serialization.th90;
import java.util.Date;

public class th90Test {
    @Test
    public void test() {
        String filename = "period.ser";
        Serials.write(filename, new th90.Period(new Date(), new Date()));
        th90.Period period = Serials.read(filename);
        System.out.println("反序列化后对象:" + period);
    }
}
