package com.hzau._16power;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/1
 */
public class Power {
    /**
     * 幂函数
     * @param base  底数
     * @param exponent  幂
     * @return  结果
     */
    public double pow(double base, int exponent) {
        //如果底数小于0，且幂为负数，直接返回0.0
        if (((Double) base).equals(0.0) && exponent < 0) {
            return 0.0;
        }
        //取幂的绝对值
        int absExponent = exponent > 0 ? exponent : -exponent;
        //计算出幂的绝对值的结果
        double results = powCore(base, absExponent);
        //如果幂小于0，结果取其倒数
        if (exponent < 0) {
            results = 1 / results;
        }
        return results;
    }

    /**
     * 幂函数的核心算法
     * @param base  底数
     * @param exponent 幂
     * @return  结果
     */
    private double powCore(double base, int exponent) {
        //直接返回前两个值
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        //递归进行计算
        double results = powCore(base, exponent >> 1);
        //每次取平方
        results *= results;
        //如果不能被2整除(余1),就再乘一次底数
        if ((exponent & 0x1) == 1) {
            results *= base;
        }
        return results;
    }
}
