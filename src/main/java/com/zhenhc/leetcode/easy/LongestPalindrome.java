package com.zhenhc.leetcode.easy;


import java.util.Arrays;

/**
 * 最长回文串
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        for (int i=0;i<s.length();++i){
            System.out.println(Integer.valueOf(s.charAt(i)));
        }
        System.out.println(longestPalindrome(s));
    }
    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            //count是int[],c是字符char,c被强转为int型，也就是ASCII码值
            count[c]++;
        }
        System.out.println(Arrays.toString(count));
        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
