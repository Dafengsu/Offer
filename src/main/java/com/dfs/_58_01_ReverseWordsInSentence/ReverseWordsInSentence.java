package com.dfs._58_01_ReverseWordsInSentence;

import java.util.Stack;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/21
 */
public class ReverseWordsInSentence {
    public String ReverseSentence(String str) {
        StringBuilder res = new StringBuilder();
        if (str == null || str.length() == 0) {
            return String.valueOf(res);
        }
        StringBuilder cur = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                stack.add(cur);
                cur = new StringBuilder();
                stack.add(new StringBuilder().append(' '));
            } else {
                cur.append(str.charAt(i));
            }

        }
        stack.add(cur);

        while (!stack.isEmpty()) {
            res.append(stack.pop().toString());

        }
        return String.valueOf(res);
    }
    public String ReverseSentence2(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int blank = -1;
        int nextBlank;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                nextBlank = i;
                reverse(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
        }
        reverse(chars, blank + 1, chars.length - 1);
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
