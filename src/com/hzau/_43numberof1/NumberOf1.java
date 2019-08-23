package com.hzau._43numberof1;

/**
 * @description:    面试题43：1-n整数中出现1的次数
 * @author: Dafengsu
 * @date: 2019/8/17
 */
public class NumberOf1 {
    /**
     * 根据位数求次数
     * @param n
     * @return
     */
    public int numberOf1Between1AndNSolution(int n) {
        //n小于等于0,直接返回
        if(n <= 0) {
            return 0;
        }
        //统计次数
        int count = 0;
        //被除数
        long divider;
        //i代表统计位数
        for (long i = 1; i <= n; i *= 10) {
            //被除数为统计位数的10倍
            divider = i * 10;
            //(n/divider)*i为当前位出现1的次数,Math.min(Math.max(n % divider - i + 1, 0), i)为补充
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0), i);
        }
        return count;
    }


}
