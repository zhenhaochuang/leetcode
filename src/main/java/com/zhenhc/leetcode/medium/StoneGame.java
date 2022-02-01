package com.zhenhc.leetcode.medium;

/**
 * 877. 石子游戏
 */
public class StoneGame {
    public static void main(String[] args) {
        int[] piles = {5,3,4,5};
        System.out.println(stoneGame(piles));
        System.out.println(stoneGame2(piles));
        System.out.println(stoneGame3(piles));
    }

    /**
     * 方法一：动态规划
     * @param piles
     * @return
     */
    public static boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

    /**
     * 使用一维数组代替二维数组，对空间进行优化。
     * @param piles
     * @return
     */
    public static boolean stoneGame2(int[] piles) {
        int length = piles.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] > 0;
    }

    /**
     * 方法二：数学
     * @param piles
     * @return
     */
    public static boolean stoneGame3(int[] piles) {
        return true;
    }
}
