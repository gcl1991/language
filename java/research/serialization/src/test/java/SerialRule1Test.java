import org.junit.Test;

public class SerialRule1Test {
    @Test
    public void test(){
        Serials.write("rule1Son.ser",new SerialRule1Son());
        Serials.read("rule1Son.ser");
    }
}
