package com.zhenhc.leetcode.sorts;

public abstract class Sort<T extends Comparable<T>> {
    protected static Integer[] nums = {4,87,90,34,23,6};

    public abstract void sort(T[] nums);

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
