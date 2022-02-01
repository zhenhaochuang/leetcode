package com.zhenhc.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *  Z 字形变换
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert1(s,numRows));
        System.out.println(convert2(s,numRows));
    }

    /**
     * 方法一：按行排序
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    /**
     * 方法二：按行访问
     * @param s
     * @param numRows
     * @return
     */
    public static String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

}