import org.junit.Test;

import java.time.LocalDate;

public class MethodTest {
    @Test
    public void test(){
        Method.B b = new Method.B(LocalDate.now());
        Method.A<LocalDate> a = b;
        a.setFirst(LocalDate.now());
        a.getFirst();
    }
}
