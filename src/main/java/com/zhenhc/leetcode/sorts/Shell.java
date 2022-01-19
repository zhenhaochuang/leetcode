package com.zhenhc.leetcode.sorts;

import java.util.Arrays;

/**
 * shell排序
 * @param <T>
 */
public class Shell<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {

        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Shell<Integer> shell = new Shell<>();
        Integer[] nums = {4,87,90,34,23,6};
        shell.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
