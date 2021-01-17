package general;

import org.junit.Test;

public class th63Test {
    private th63 th63 = new th63();

    @Test
    public void testSpeedSlow() {
        th63.statementSlow();
    }

    @Test
    public void testSpeedFast() {
        th63.statementFast();
    }
}
