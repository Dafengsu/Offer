package com.dfs._48longestsubstringwithoutdup;

import java.util.Arrays;

/**
 * @description:    面试题48：最长不含重复字符的子字符串
 * @author: Dafengsu
 * @date: 2019/8/19
 */
public class LongestSubstringWithoutDup {
    /**
     * 动态规划法
     * @param string
     * @return
     */
    public int longestSubstringWithoutDuplication(String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        int res = 0;
        int cur = 0;
        //创建一个大小为26的数组
        int[] position = new int[26];
        Arrays.fill(position, -1);
        int preIndex;
        for (int i = 0; i < string.length(); i++) {
            preIndex = position[string.charAt(i) - 'a'];
            if (preIndex < 0 || i - preIndex > cur) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = i - preIndex;
            }
            position[string.charAt(i) - 'a'] = i;
        }
        res = Math.max(res, cur);
        return res;
    }
}
