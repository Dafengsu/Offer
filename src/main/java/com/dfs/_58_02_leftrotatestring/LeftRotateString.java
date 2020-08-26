package com.dfs._58_02_leftrotatestring;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/21
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        char[] tempChars = new char[n];
        System.arraycopy(chars, 0, tempChars, 0, n );
        System.arraycopy(chars, n, chars, 0, chars.length - n);
        System.arraycopy(tempChars, 0, chars, chars.length  - n, n);
        return String.valueOf(chars);
    }
    public String LeftRotateString2(String str,int n) {
        if (str == null || str.length() == 0 || n == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }
    private void reverse(char[] chars, int start, int end) {
        char temp;
        while (start < end) {
            temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
