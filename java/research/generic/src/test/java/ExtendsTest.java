import org.junit.Test;

public class ExtendsTest {
    @Test
    public void testExtends(){
        Extends.A<Extends.B> a = new Extends.A<>();
        Extends.D<Extends.C> e = new Extends.D<>();
    }
}
