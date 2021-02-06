package objects.method;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class th10Test {
    @Test
    public void testSymmetry() {
        th10.CaseInsensitiveString cis = new th10.CaseInsensitiveString("Polish");
        String s = "polish";
        assertFalse(s.equals(cis));
        assertTrue(cis.equals(s));

        th10.Point p = new th10.Point(1, 2);
        th10.ShapePoint cp = new th10.ShapePoint(1, 2, 3);
        assertTrue(p.equals(cp));
        assertFalse(cp.equals(p));

        List list = new ArrayList<>();
        list.add(cis);
        assertFalse(list.contains(s));

        list.clear();
        list.add(s);
        assertTrue(list.contains(cis));
    }

    @Test
    public void testTransitivity() {
        th10.ColorPoint p1 = new th10.ColorPoint(1, 2, Color.RED);
        th10.Point p2 = new th10.Point(1, 2);
        th10.ColorPoint p3 = new th10.ColorPoint(1, 2, Color.BLUE);
        assertEquals(p1, p2);
        assertEquals(p2, p3);
        assertNotEquals(p1, p3);
    }

    @Test(expected = StackOverflowError.class)
    public void testRecursive(){
        th10.ColorPoint p1 = new th10.ColorPoint(1, 2, Color.RED);
        th10.SmellPoint p2 = new th10.SmellPoint(1, 2, 3);
        p1.equals(p2);
    }

    @Test
    public void testLiskov(){
        assertTrue(th10.onUnitCircle(new th10.Shape(1,0)));
        assertFalse(th10.onUnitCircle(new th10.CounterShape(1,0)));
    }
}
