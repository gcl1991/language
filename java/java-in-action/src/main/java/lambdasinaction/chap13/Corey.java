package lambdasinaction.chap13;

import java.util.function.DoubleUnaryOperator;

public class Corey {
    public static void main(String[] args) {
        DoubleUnaryOperator f = curriedConverter(1,2);
        System.out.println(f.applyAsDouble(10));
    }

    public static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }
}
