package serialization.th87;

import org.junit.Test;
import serialization.Serials;

public class th84Test {
    @Test
    public void test(){
        String filename = "stringList.ser";
        StringList before = new StringList();
        Serials.write(filename,before);
        StringList after  = Serials.read(filename);
        System.out.println(before);
        System.out.println(after);
    }
}
