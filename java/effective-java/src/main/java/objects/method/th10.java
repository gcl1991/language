package objects.method;

import java.awt.Color;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class th10 {
    // 违反对称性
    // Broken - violates symmetry!
    public final static class CaseInsensitiveString {
        private final String s;

        public CaseInsensitiveString(String s) {
            this.s = Objects.requireNonNull(s);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof CaseInsensitiveString) {
                return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
            }

            // One-way interoperability!
            if (o instanceof String){
                return s.equalsIgnoreCase((String) o);
            }

            return false;
        }
        // Remainder omitted
    }

    public static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o){
                return true;
            }

            if (!(o instanceof Point)) {
                return false;
            }

            Point p = (Point)o;
            return p.x == x && p.y == y;
        }
    }

    // 违反对称性
    public static class ShapePoint extends Point {
        private final int shape;

        public ShapePoint(int x, int y, int shape) {
            super(x, y);
            this.shape = shape;
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ShapePoint)) {
                return false;
            }

            // o is a ColorPoint; do a full comparison
            return super.equals(o) && ((ShapePoint) o).shape == shape;
        }
    }


    // 导致传递性和无限递归
    public static class ColorPoint extends Point {
        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }

            // If o is a normal Point, do a color-blind comparison
            if (!(o instanceof ColorPoint)) {
                return o.equals(this);
            }

            // o is a ColorPoint; do a full comparison
            return super.equals(o) && ((ColorPoint) o).color == color;
        }
    }

    public static class SmellPoint extends Point{
        private final int smell;

        public SmellPoint(int x, int y,int smell) {
            super(x, y);
            this.smell  = smell;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }

            // If o is a normal Point, do a color-blind comparison
            if (!(o instanceof SmellPoint)) {
                return o.equals(this);
            }

            // o is a ColorPoint; do a full comparison
            return super.equals(o) && ((SmellPoint) o).smell == smell;
        }
    }

    // 违反Liskov替换原则
    public static class Shape{
        private final int x;
        private final int y;

        public Shape(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || o.getClass() != getClass()) {
                return false;
            }

            Shape p = (Shape) o;
            return p.x == x && p.y == y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static class CounterShape extends Shape {
        private static final AtomicInteger counter = new AtomicInteger();

        public CounterShape(int x, int y) {
            super(x, y);
            counter.incrementAndGet();
        }

        public static int numberCreated() {
            return counter.get();
        }
    }

    // Initialize unitCircle to contain all Points on the unit circle
    private static final Set<Shape> unitCircle = new HashSet<>();
    static {
        unitCircle.add(new Shape(1,0));
        unitCircle.add(new Shape( 0, 1));
        unitCircle.add(new Shape(-1, 0));
        unitCircle.add(new Shape( 0, -1));

    }
    public static boolean onUnitCircle(Shape p) {
        return unitCircle.contains(p);
    }

}
