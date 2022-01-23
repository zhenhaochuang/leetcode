package com.zhenhc.leetcode.medium;

/**
 * 整数转罗马数字
 * 罗马数字包含以下七种字符： I=1， V=5， X=10， L=50，C=100，D=500 和 M=1000。
 */

public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman1(78));  //LXXVIII
        System.out.println(integerToRoman.intToRoman2(78));  //LXXVIII
    }

    /**
     * 方法一：模拟
     */
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman1(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

    /**
     * 方法二：硬编码数字
     */
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman2(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }
}
