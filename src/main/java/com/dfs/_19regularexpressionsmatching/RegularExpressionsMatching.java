package com.dfs._19regularexpressionsmatching;

/**
 * @description: 面试题19:匹配字符串
 * @author: Dafengsu
 * @date: 2019/8/6
 */
public class RegularExpressionsMatching {
    /**
     * 匹配字符串
     * @param str   目标字符串
     * @param pattern   匹配模式
     * @return  返回是否匹配
     */
    public boolean match(char[] str, char[] pattern) {
        //如果字符串或者模式为空，直接返回false
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, 0, pattern);
    }

    /**
     * 字符串匹配的核心代码
     * @param str   匹配字符串
     * @param strIndex     匹配字符串下标
     * @param patternIndex 模式下标
     * @param pattern      模式
     * @return  返回是否匹配成功
     */
    private boolean matchCore(char[] str, int strIndex, int patternIndex, char[] pattern) {
        //如果字符串下标超过或者等于字符串长度（递归时会+1）且模式长度等于下标
        //代表已经匹配完毕，并且匹配成功
        if (strIndex >= str.length && patternIndex == pattern.length) {
            return true;
        }
        //如果模式下标已经匹配完毕，但是字符串还有为匹配完，代表匹配失败
        if (patternIndex >= pattern.length && strIndex < str.length) {
            return false;
        }
        //当前模式的下一个下标在范围内，且模式的下一个字符是‘*’
        if(patternIndex+1 < pattern.length && pattern[patternIndex+1] == '*'){
            //字符数组下标不越界且当前字符数组的下标的值等于当前模式的值，或者当前模式的值是‘.’
            if (strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
                        //模式下标移动两位继续匹配（字符串没有对应匹配值)
                return matchCore(str, strIndex, patternIndex + 2, pattern) ||
                        //字符数组移动一位，模式数组移动两位继续匹配（字符串有一个对应的值）
                        matchCore(str, strIndex + 1, patternIndex + 2, pattern) ||
                        //字符数组移动一位，模式数组不移动继续匹配（字符串有超过一位的对应值）
                        matchCore(str, strIndex + 1, patternIndex, pattern);
                //字符数组越界，或者字符数组与模式数组不匹配
            } else {
                //字符数组移动一位，模式数组不移动继续匹配（字符串有超过一位的对应值）
                return matchCore(str, strIndex, patternIndex + 2, pattern);
            }
        }
        //字符数组下标在范围内切字符数组与模式数组匹配或者模式是‘.’
        if (strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
            //字符数组下标和模式下标都移动一位
            return matchCore(str, strIndex + 1, patternIndex + 1, pattern);
        }
        //超出一上范围，直接返回false
        return false;
    }

}
