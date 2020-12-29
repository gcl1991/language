package serialization.th87;

import org.junit.Test;
import serialization.Serials;
import serialization.th88;

import java.util.Calendar;
import java.util.Date;

public class th88Test {
    @Test
    public void test() {
        String filename = "periodA.ser";
        th88.Period period = Serials.read(filename);
        System.out.println(period);
    }

    @Test
    public void testFakeByteStream() {
        th88.MutablePeriod mp = new th88.MutablePeriod();
        th88.Period p = mp.period;
        Date pEnd = mp.end;
        // Let's turn back the clock
        // 我们回头看看时间
        pEnd.setYear(78);
        System.out.println(p);
        // Bring back the 60s!
        // 带回60年代！
        pEnd.setYear(69);
        System.out.println(p);
    }
}
