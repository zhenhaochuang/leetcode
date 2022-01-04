package com.zhenhc.leetcode.easy;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] grid = {1,3};
        int[] size = {1,2,4};
        System.out.println(findContentChildren(grid,size));
    }
    public static int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
