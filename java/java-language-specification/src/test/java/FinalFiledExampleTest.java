import org.junit.Test;

public class FinalFiledExampleTest {
    @Test
    public void test() throws InterruptedException {
        while (true){
            Thread t1 = new Thread(FinalFiledExample::writer);
            Thread t2 = new Thread(FinalFiledExample::reader);
            t1.start();
            t2.start();
            // 没有复现y=0的情况
        }
    }
}
