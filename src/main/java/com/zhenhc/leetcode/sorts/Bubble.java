package com.zhenhc.leetcode.sorts;

import java.util.Arrays;

/**
 * 冒泡排序
 * @param <T>
 */
public class Bubble<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean isSorted = false;
        for (int i = N - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    isSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Bubble<Integer> bubble = new Bubble<>();
        Integer[] nums = {4,87,90,34,23,6};
        bubble.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
