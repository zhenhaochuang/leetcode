package com.zhenhc.leetcode.easy;

import java.util.Scanner;

/**
 * 判断一个非负整数是否为两个整数的平方和。
 */
public class SumOfSquareNumbers {

    public static void main(String[] args) {
        //int target = 8;
        int target = 0;
        Scanner scanner = new Scanner(System.in);
        while (target != -1) {
            System.out.println("please input target:");
            target = scanner.nextInt();
            System.out.println(judgeSquareSum(target));
        }
        scanner.close();
    }
    public static boolean judgeSquareSum(int target) {
        if (target < 0) return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                System.out.println(i + "*" + i +"+" + j + "*" + j );
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
