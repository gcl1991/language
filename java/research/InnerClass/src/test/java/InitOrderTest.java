import org.junit.Test;

public class InitOrderTest {
    @Test
    public void testOuterClinit() {
        System.out.println("测试外部类Clinit时，静态内部类是否会触发Clinit");
        new InitOrder();
    }

    @Test
    public void testInnerClinit(){
        System.out.println("测试内部静态类Clinit时，外部类是否会触发Clinit");
        new InitOrder.Inner();
    }
}
