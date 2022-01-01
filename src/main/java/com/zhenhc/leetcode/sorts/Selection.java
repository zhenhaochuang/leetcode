package com.zhenhc.leetcode.sorts;

import java.util.Arrays;

public class Selection<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {4,87,90,34,23,6};
        Selection<Integer> selection = new Selection<>();
        selection.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
