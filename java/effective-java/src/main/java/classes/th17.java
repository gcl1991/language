package classes;

// 最小化可变性：除非必要，否则类应该是不可变的
public class th17 {
    // 1 优先创建不可变类（1）所有字段为private final,（2）禁止继承，（3）不提供set方法，（4）确保可变组件的独占性访问权（入/出/自身，必要时使用防御性拷贝）
    // 2 可以使用静态工厂方法对指定范围不可变值进行缓存，减少内存占用，如BigInteger
    // 3 提供常用数值，避免中间计算产生大量不可变对象导致的性能和内存损耗，
    // 4 禁用继承：使用全部构造器私有化+静态构造器代替final class
    // 5 确认有必要实现令人满意的性能时，才应该为不可改变类提供一个公开的可变伙伴类String/StringBuilder。

    // Immutable complex number class
    public static final class Complex {
        private final double re;
        private final double im;
        public static final Complex ZERO = new Complex(0, 0);
        public static final Complex ONE = new Complex(1, 0);
        public static final Complex I = new Complex(0, 1);
        private Complex(double re, double im) {
            this.re = re;
            this.im = im;
        }
        public static Complex valueOf(double re, double im) {
            return new Complex(re, im);
        }
        public double realPart() {
            return re;
        }
        public double imaginaryPart() {
            return im;
        }
        public Complex plus(Complex c) {
            return new Complex(re + c.re, im + c.im);
        }
        public Complex minus(Complex c) {
            return new Complex(re - c.re, im - c.im);
        }
        public Complex times(Complex c) {
            return new Complex(re * c.re - im * c.im,
                    re * c.im + im * c.re);
        }
        public Complex dividedBy(Complex c) {
            double tmp = c.re * c.re + c.im * c.im;
            return new Complex((re * c.re + im * c.im) / tmp,
                    (im * c.re - re * c.im) / tmp);
        }
        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Complex)) {
                return false;
            }
            Complex c = (Complex) o;
            // See page 47 to find out why we use compare instead of ==
            return Double.compare(c.re, re) == 0
                    && Double.compare(c.im, im) == 0;
        }
        @Override
        public int hashCode() {
            return 31 * Double.hashCode(re) + Double.hashCode(im);
        }
        @Override
        public String toString() {
            return "(" + re + " + " + im + "i)";
        }
    }
}
