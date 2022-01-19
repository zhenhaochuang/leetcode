package com.zhenhc.leetcode.sorts.merge.sort;

import com.zhenhc.leetcode.sorts.Bubble;

import java.util.Arrays;

/**
 * 自顶向下归并排序
 */
public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }

    public static void main(String[] args) {
        Up2DownMergeSort<Integer> up2DownMergeSort = new Up2DownMergeSort<>();
        Integer[] nums = {4,87,90,34,23,6};
        up2DownMergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}