package com.zhenhc.leetcode.easy;

/**
 * 爬楼梯
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
