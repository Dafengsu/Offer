package com.hzau._60_dicesprobability;

import java.util.Arrays;

/**
 * @description:    面试题60：n个骰子的个数
 * @author: Dafengsu
 * @date: 2019/8/22
 */
public class DicesProbability {
    private int maxValue = 6;
    public double[] dicesProbability(int number) {
        if (number < 1) {
            return null;
        }
        int maxSum = maxValue * number;
        double[] res = new double[maxSum - number + 1];
        Arrays.fill(res, 0);
        probabilityCore(res, number);
        double total = Math.pow(6, number);
        for (int i = 0; i < res.length; i++) {
            res[i] /= total;
        }
        return res;
    }

    private void probabilityCore(double[] res, int number) {
        for (int i = 1; i <= maxValue; i++) {
            probabilityCore(number, number, i, res);
        }
    }

    /**
     * 递归核心代码
     * @param original  总共有多少骰子
     * @param current   当前是倒数第几枚骰子
     * @param sum   目前的总点数
     * @param res   结果
     */
    private void probabilityCore(int original, int current, int sum, double[] res) {
        //如果是最后一枚骰子，记录结果
        if (current == 1) {
            res[sum - original]++;
        } else {
            for (int i = 1; i <= maxValue; i++) {
                probabilityCore(original, current - 1, i + sum, res);
            }
        }
    }

    /**
     * 非递归的方法
     * @param number
     * @return
     */
    public double[] dicesProbability2(int number) {
        if (number < 1) {
            return null;
        }
        int maxSum = maxValue * number;
        double[][] resCollection = new double[2][maxValue * number + 1];
        double[] res = new double[maxSum - number + 1];
        Arrays.fill(resCollection[0], 0);
        Arrays.fill(resCollection[1], 0);
        int flag = 0;
        //第一次掷骰子各个数字出现的次数
        for (int i = 1; i <= maxValue; i++) {
            resCollection[flag][i] = 1;
        }
        //从第二次开始循环递归
        for (int k = 2; k <= number; k++) {
            //把小于当前骰子数的数的次数置为0
            for (int i = 0; i < k; i++) {
                resCollection[1 - flag][i] = 0;
            }
            //从与当前骰子数相等的数的次数开始
            //i代表骰子之和的数
            for (int i = k; i <= maxValue * k; i++) {
                //先将次数置为0
                resCollection[1 - flag][i] = 0;
                //把i之前前6位相加
                //j代表上与前一次骰子之和与当前骰子之和相差j的上一次的骰子之和的数，最大相差5
                for (int j = 1; j <= i && j <= maxValue; j++) {
                    resCollection[1 - flag][i] += resCollection[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = Math.pow(maxValue, number);
        for (int i = number; i <= maxValue * number; i++) {
            resCollection[flag][i] /= total;
        }
        System.arraycopy(resCollection[flag], number, res, 0, res.length);
        return res;
    }
}
