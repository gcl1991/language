import org.junit.Test;

public class DeserializeBombTest {
    @Test
    public void test() {
        long start = System.nanoTime();
        Serials.write("bomb.ser", new DeserializeBomb());
        long write = System.nanoTime();
        System.out.println(String.format("序列化时间:%s ms", (write - start)/1000_000));

        Serials.<DeserializeBomb>read("bomb.ser");
        long end = System.nanoTime();
        System.out.println(String.format("反序列化时间:%s ms", (end - write)/1000_000));
    }
}
