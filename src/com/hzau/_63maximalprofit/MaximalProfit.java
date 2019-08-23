package com.hzau._63maximalprofit;

/**
 * @description:    面试题63：股票的最大利润
 * @author: Dafengsu
 * @date: 2019/8/22
 */
public class MaximalProfit {
    public int maxDiff(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int min = numbers[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < numbers.length; i++) {
            min = Math.min(min, numbers[i - 1]);
            res = Math.max(res, numbers[i] - min);
        }
        return res;
    }
}
