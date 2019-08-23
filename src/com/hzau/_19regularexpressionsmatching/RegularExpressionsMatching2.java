package com.hzau._19regularexpressionsmatching;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/6
 */
public class RegularExpressionsMatching2 {
    /**
     * 匹配字符串
     * @param str   字符数组
     * @param pattern   匹配模式
     * @return  是否匹配成功
     */
    public boolean match(char[] str, char[] pattern) {
        return matchCore(str, 0, 0, pattern);
    }

    /**
     * 匹配字符串核心代码
     * @param str   字符数组
     * @param strIndex  字符数组下标
     * @param patternIndex  模式数组下标
     * @param pattern   模式数组
     * @return  是否匹配成功
     */
    private boolean matchCore(char[] str, int strIndex, int patternIndex, char[] pattern) {
        //如果字符数组和模式数组匹配完毕，则匹配成功
        boolean matchSuccess = (strIndex == str.length) && (patternIndex == pattern.length);
        if (matchSuccess) {
            return true;
        }
        //如果模式数组匹配完毕但是字符数组还有剩余，匹配失败(或者相反)
        boolean matchFailure = strIndex < str.length && patternIndex == pattern.length;
        if (matchFailure) {
            return false;
        }

        //如果模式数组的下一个是’*‘
        if ((patternIndex + 1) < pattern.length && pattern[patternIndex+1] == '*') {
            //如果字符数组不越界且当前字符和模式匹配或者当前模式为’.‘
            if (strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
                //模式数组下标移动两位继续匹配（直接跳过’*‘）
                return matchCore(str, strIndex, patternIndex + 2, pattern)
                        //模式数组下标移动两位，字符数字移动一位，继续匹配（匹配一位）
                        || matchCore(str, strIndex + 1, patternIndex + 2, pattern)
                        //模式不移动，字符数组移动一位（不知一位字符和模式匹配）;
                        || matchCore(str, strIndex + 1, patternIndex, pattern);
                //字符数组越界，或者字符数组和模式数组不匹配
            } else {
                return matchCore(str, strIndex, patternIndex + 2, pattern);
            }
        }

        //如果模式数组和字符数字匹配或者模式数组的当前位为’.‘
        if (strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
            return matchCore(str, strIndex + 1, patternIndex + 1, pattern);
        }
        return false;
    }
}
