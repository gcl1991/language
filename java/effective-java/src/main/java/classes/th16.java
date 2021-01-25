package classes;

// 在公共类中使用访问方法而不是公共属性
public class th16 {
    // 1 如果一个类在其包之外是可访问的，则提供访问器方法来保留更改类内部表示的灵活性。
    // 2 包级私有的类，则不必使用访问器方法。
    // 3 公共类暴露不可变属性的危害虽然小，但是也应尽量避免。

    // Degenerate classes like this should not be public!
    // 这样的退化类不应公开!
    class Point1 {
        public double x;
        public double y;
    }

    // Encapsulation of data by accessor methods and mutators
    // 通过访问器方法和更改器封装数据
    class Point2 {
        private double x;
        private double y;
        public Point2(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public double getX() { return x; }
        public double getY() { return y; }
        public void setX(double x) { this.x = x; }
        public void setY(double y) { this.y = y; }
    }
}
