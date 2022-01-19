package com.zhenhc.leetcode.sorts;

import java.util.Arrays;

/**
 * 插入排序
 * @param <T>
 */
public class Insertion<T extends Comparable<T>> extends Sort<T> {

    public static void main(String[] args) {
        Insertion<Integer> insertion = new Insertion<>();
        Integer[] nums = {4,87,90,34,23,6};
        insertion.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }
    }
}