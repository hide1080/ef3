package chap07.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Pi {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long c = pi((long) Math.pow(10, 7));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(c);

        start = System.currentTimeMillis();
        c = pi((long) Math.pow(10, 7));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(c);
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
}
