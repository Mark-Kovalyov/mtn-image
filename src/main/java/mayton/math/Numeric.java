package mayton.math;

import java.math.*;

public class Numeric {

    /**
     * Функция Аккермана. (Нахер нужна - непонятно!)
     *
     * @param a
     * @param b
     * @return
     */
    public static int akkerman(int m, int n) {
        if (m == 0) return n + 1;
        if ((m > 0) && (n > 0)) return akkerman(m - 1, 1);
        return akkerman(m - 1, akkerman(m, n - 1));
    }

    public static double pow2(double d) {
        return d * d;
    }

    public static int pow2(int i) {
        return i * i;
    }

    /**
     * Приближённый логарифм по основанию 2
     *
     * @param x
     * @return
     */
    public static double log2(double x) {
        assert (x >= 0.0d);
        return Math.log(x) / Math.log(2.0);
    }

    /**
     * Вычисление факториала в диапазоне int
     *
     * @param x
     * @return
     * @throws IllegalArgumentException
     */
    public static long fact(int x) throws IllegalArgumentException {
        return fact((long) x);
    }

    /**
     * Факториал
     *
     * @param x
     * @return
     * @throws java.lang.IllegalArgumentException
     */
    public static long fact(long x) throws IllegalArgumentException {
        assert (x >= 0);
        if (x == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        long tx = 1;
        for (long i = 2; i <= x; i++) {
            tx *= i;
        }
        return tx;
    }

    /**
     * Вычитание факториалов
     *
     * @param x1
     * @param x2
     * @return
     * @throws IllegalArgumentException
     */
    public static long subFact(long x1, long x2) throws IllegalArgumentException {
        assert (x1 <= x2);
        if ((x1 <= 0) || (x2 <= 0)) {
            throw new IllegalArgumentException();
        }
        if (x1 == x2) {
            return x1;
        }
        long prod = 1;
        for (long i = x1; i <= x2; i++) {
            prod *= i;
        }
        return prod;
    }

    /**
     * Число сочетаний - часто используемая формула в
     * комбинаторике. Это количество вариантов выбрать из множества
     * объектов n наборы по k объектов.
     *
     * @param n
     * @param k
     * @return
     */
    public static long permutation(long n, long k) {
        assert (n > k);
        assert (n >= 0);
        assert (k >= 0);
        return fact(n) / (fact(k) * fact(n - k));
        // 3! /
        //return subFact(m+1,n)/fact(n-m);
    }

    /**
     * Количество размещений (не реализовано)
     *
     * @param n
     * @param m
     * @return
     */
    public static long permutationWithRepetition(long n, long m) {
        throw new RuntimeException("Not implemented yet!");
    }

    /**
     * Деление факториалов
     *
     * @param a1 делимое
     * @param a2 делитель
     * @return частное
     * @throws IllegalArgumentException
     */
    public static BigInteger factDivision(BigInteger a1, BigInteger a2) throws IllegalArgumentException {
        if (a1.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        if (a2.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        BigInteger mul = new BigInteger(a1.toString());
        for (BigInteger i = new BigInteger(a1.toString()); i.compareTo(a2) < 0; i.add(BigInteger.ONE)) {
            mul.multiply(i);
        }
        return mul;
    }

    /**
     * Вычисление факториала в бесконечно большом диапазоне
     *
     * @param x
     * @return x!
     * @throws IllegalArgumentException
     */
    public static BigInteger fact(BigInteger x) throws IllegalArgumentException {
        if (x.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        if (x.compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ONE;
        }
        if (x.compareTo(BigInteger.ONE) == 0) {
            return BigInteger.ONE;
        }
        BigInteger mul = BigInteger.ONE;
        BigInteger i = BigInteger.ONE;
        while (i.compareTo(x) <= 0) {
            mul = mul.multiply(i);
            i = i.add(BigInteger.ONE);
        }
        return mul;
    }
}
