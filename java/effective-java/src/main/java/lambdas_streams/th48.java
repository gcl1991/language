package lambdas_streams;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import static java.math.BigInteger.ONE;

public class th48 {
    static final BigInteger TWO = BigInteger.valueOf(2);
    // Stream-based program to generate the first 20 Mersenne primes
    public static void main(String[] args) {
        primes().parallel().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    static long piSerial(long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    static long piParallel(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}
