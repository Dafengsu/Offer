package com.dfs._67_stringtoint;

/**
 * @description:    面试题67：把字符串转换成整数
 * @author: Dafengsu
 * @date: 2019/8/23
 */
public class StringToInt {
    /**
     * 字符串转换成整数：
     * 1.处理了前面无数个的空格和+-号
     * 2.处理了所有的非法输入
     * 2.不借助long类型或其他辅助类完成了溢出处理。
     * 3.溢出处理是参照 Integer.parseInt()写的，
     * 采用的是负累积计算（因为负整数的绝对值更大）
     * 4.没有区分非法输入和溢出，区分很简单加一个全局
     * 标识符就可以了，懒得写了。
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if(str==null || str.length()==0) {
            return 0;
        }
        int start = 0;
        //正负标识符
        int flag = 1;
        char[] chars = str.toCharArray();
        int res = 0;
        while (start < chars.length && (chars[start] < '0' || chars[start] > '9')) {
            if (chars[start] == '-') {
                flag *= -1;
            } else if (chars[start] == '+' || chars[start] == ' ') {

            } else {
                return 0;
            }
            start++;
        }
        int limit = flag == 1 ? -Integer.MAX_VALUE : Integer.MIN_VALUE;
        int muLimit = limit / 10;
        int digit;
        //采用符累积
        for (int i = start; i < chars.length; i++) {
            digit = chars[i] - '0';
            if (digit < 0 || digit > 9) {
                return 0;
            }
            //处理单纯进位就溢出的情况
            if (res < muLimit) {
                return 0;
            }
            res *= 10;
            //处理进位再加上digit溢出的情况
            //此次运算的不越界结果应该是res - digit,为了与边界limit进行不越界对比
            //同时加上digit,既res 和limit+digit对比，如果res更下，说明digit越界了。
            if (res < limit + digit) {
                return 0;
            }
            res -= digit;
        }
        return flag == 1 ? -res : res;
    }

}
