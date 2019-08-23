package com.hzau._50_01_firstnotrepeatingchar;

import java.util.Arrays;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/19
 */
public class FirstNotRepeatingChar {
    /**
     * 创建一个数组作为辅助空间
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] position = new int[58];
        Arrays.fill(position, -1);
        int res = -1;
        for (int i = 0; i < str.length(); i++) {
            if (position[str.charAt(i) - 'A'] == -1) {
                position[str.charAt(i) - 'A'] = i;
            } else {
                position[str.charAt(i) - 'A'] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < 58; i++) {
            if (position[i] >= 0) {
                if (res == -1) {
                    res = position[i];
                } else {
                    res = Math.min(position[i], res);
                }
            }
        }
        return res;
    }

}
