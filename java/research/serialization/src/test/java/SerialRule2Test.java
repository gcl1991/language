import org.junit.Test;

public class SerialRule2Test {
    @Test
    public void test(){
        Serials.write("rule2Son.ser",new SerialRule2Son());
        Serials.read("rule2Son.ser");
    }
}
