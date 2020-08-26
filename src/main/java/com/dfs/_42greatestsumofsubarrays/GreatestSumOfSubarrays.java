package com.dfs._42greatestsumofsubarrays;

/**
 * @description:    面试题42：连续数组的最大子数组和
 * @author: Dafengsu
 * @date: 2019/8/17
 */
public class GreatestSumOfSubarrays {
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int curSum = 0;
        int resSum = 0;
        int maxValue = array[0];
        int count = 0;
        for (int value : array) {
            maxValue = Math.max(maxValue, value);
            if (value < 0) {
                resSum = Math.max(curSum, resSum);
                curSum = Math.max((curSum + value), 0);
            } else {
                curSum += value;
                count++;
            }
        }
        resSum = Math.max(curSum, resSum);
        return count == 0 ? maxValue : resSum;
    }
    public int findGreatestSumOfSubArray2(int[] array) {
        int curSum = 0;
        int resSum = Integer.MIN_VALUE;
        for (int value : array) {
            if (curSum <= 0) {
                curSum = value;
            } else {
                curSum += value;
            }
            resSum = Math.max(resSum, curSum);
        }
        return resSum;
    }
}
