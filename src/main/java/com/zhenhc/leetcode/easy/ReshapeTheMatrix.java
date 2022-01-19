package com.zhenhc.leetcode.easy;

import java.util.Arrays;

/**
 * 重复矩阵
 */
public class ReshapeTheMatrix {

    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4},{5,6},{7,8}};
        int r = 1;
        int c = 8;
        int[][] result = matrixReshape(nums,r,c);
        System.out.println(Arrays.deepToString(result));
    }
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }
}

