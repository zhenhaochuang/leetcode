package com.zhenhc.leetcode.easy;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram1(s,t));
        System.out.println(isAnagram2(s,t));
        System.out.println(isAnagram3(s,t));
    }

    /**
     * 排序：把字符串转为字符数组，然后使用Arrays工具类对字符数组排序，比较排序之后的数组是否相等。
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
    /**
     * 哈希表
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
            System.out.println(Arrays.toString(cnts));
        }
        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
            System.out.println(Arrays.toString(cnts));
        }
        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 哈希表
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
