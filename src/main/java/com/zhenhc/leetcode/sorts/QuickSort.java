package com.zhenhc.leetcode.sorts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    public static void main(String[] args) {
        QuickSort<Integer> quickSort = new QuickSort<>();
        Integer[] nums = {4,87,90,34,23,6};
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums,0,nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l)
            return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    /**
     * 切分
     * @param nums 待排序的数组
     * @param l  0
     * @param h  数组长度-1
     * @return
     */
    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }
}
