import org.junit.Test;

import java.io.FileNotFoundException;

public class FinallyExeceptionTest {
    @Test
    public void testExeceptionOverride() throws FileNotFoundException {
        FinallyExeception.execeptionOverride(true);
    }
}
