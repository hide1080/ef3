package chap07.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Pi {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long p = pi((long) Math.pow(10, 7));
        report(start, p);

        start = System.currentTimeMillis();
        p = pi((long) Math.pow(10, 7));
        report(start, p);
    }

    static long pi (long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    static long pi2 (long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    static void report(long s, long p ) {
        System.out.println(String.format("response time: %s, result: %s", System.currentTimeMillis() - s, p));
    }

}
