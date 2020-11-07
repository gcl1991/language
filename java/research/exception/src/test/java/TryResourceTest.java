import org.junit.Test;

import java.io.FileNotFoundException;

public class TryResourceTest {
    @Test
    public void testTryResource() throws FileNotFoundException {
        TryResource.tryResource(true);
    }
}
