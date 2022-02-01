package com.zhenhc.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

/**
 * 方法一：动态规划 + 二分查找
 */
public class SuperEggDrop {
    public static void main(String[] args) {
        int k = 1;
        int n = 2;
        out.println(superEggDrop(k,n));
        out.println(superEggDrop2(k,n));
        out.println(superEggDrop3(k,n));
    }
    static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    public static int dp(int k, int n) {
        if (!memo.containsKey(n * 100 + k)) {
            int ans;
            if (n == 0) {
                ans = 0;
            } else if (k == 1) {
                ans = n;
            } else {
                int lo = 1, hi = n;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(k - 1, x - 1);
                    int t2 = dp(k, n - x);

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }

                ans = 1 + Math.min(Math.max(dp(k - 1, lo - 1), dp(k, n - lo)), Math.max(dp(k - 1, hi - 1), dp(k, n - hi)));
            }

            memo.put(n * 100 + k, ans);
        }

        return memo.get(n * 100 + k);
    }

    /**
     * 方法二：决策单调性
     * @param k
     * @param n
     * @return
     */
    public static int superEggDrop2(int k, int n) {
        // Right now, dp[i] represents dp(1, i)
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            dp[i] = i;
        }

        for (int j = 2; j <= k; ++j) {
            // Now, we will develop dp2[i] = dp(j, i)
            int[] dp2 = new int[n + 1];
            int x = 1;
            for (int m = 1; m <= n; ++m) {
                // Let's find dp2[m] = dp(j, m)
                // Increase our optimal x while we can make our answer better.
                // Notice max(dp[x-1], dp2[m-x]) > max(dp[x], dp2[m-x-1])
                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
                while (x < m && Math.max(dp[x - 1], dp2[m - x]) > Math.max(dp[x], dp2[m - x - 1])) {
                    x++;
                }

                // The final answer happens at this x.
                dp2[m] = 1 + Math.max(dp[x - 1], dp2[m - x]);
            }

            dp = dp2;
        }

        return dp[n];
    }

    /**
     * 方法三：数学法
     * @param k
     * @param n
     * @return
     */
    public static int superEggDrop3(int k, int n) {
        if (n == 1) {
            return 1;
        }
        int[][] f = new int[n + 1][k + 1];
        for (int i = 1; i <= k; ++i) {
            f[1][i] = 1;
        }
        int ans = -1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j];
            }
            if (f[i][k] >= n) {
                ans = i;
                break;
            }
        }
        return ans;
    }

}
