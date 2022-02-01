package com.zhenhc.leetcode.easy;

public class FibonacciNumber {

    public static void main(String[] args) {
        int n = 20;
        System.out.println(System.currentTimeMillis());
        System.out.println(fib1(n));
        System.out.println(System.currentTimeMillis());
        System.out.println(fib2(n));
        System.out.println(System.currentTimeMillis());
        System.out.println(fib2(n));
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 方法一：动态规划
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 方法二：矩阵快速幂
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);
        return res[0][0];
    }

    public static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    /**
     * 方法三：通项公式
     * @param n
     * @return
     */
    public static int fib3(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }
}
