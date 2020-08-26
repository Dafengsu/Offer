package com.dfs._39morethanhalfnumber;

import java.util.Random;

/**
 * @description:    面试题39：数组中出现次数超过一半的数组
 * @author: Dafengsu
 * @date: 2019/8/10
 */
public class MoreThanHalfNumber {
    /**
     *  通过划分子程序，找中位值
     * @param array
     * @return
     */
    public int moreThanHalfNumSolution(int[] array) {
        //判断数组是否符合
        if (checkInvalidArray(array)) {
            return 0;
        }
        //记录中位数下标
        int middle = array.length >> 1;
        //初始的起始位
        int start = 0;
        //初始的终点位
        int end = array.length - 1;
        //化分子程序
        int index = partition(array, start, end);
        //持续划分子程序，直到标志值是中位数
        while (index != middle) {
            if (index > middle) {
                index = partition(array, start, index - 1);
            } else {
                index = partition(array, index + 1, end);
            }
        }
        //检查该值在数组中出现的次数，是否超过一半
        return checkMoreThanHalf(array, middle) ? array[middle] : 0;
    }
    public int moreThanHalfNumSolution2(int[] array) {
        if (checkInvalidArray(array)) {
            return 0;
        }
        int results = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (results == array[i]) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    results = array[i];
                    count = 1;
                }
            }
        }
        return checkMoreThanHalf(array, results) ? results : 0;
    }
    /**
     * 检查数在数组中的次数是否超过一半
     * @param array 数组
     * @param index 目标数的下标
     * @return  是否
     */
    private boolean checkMoreThanHalf(int[] array, int index) {
        //统计次数
        int count = 0;
        //遍历数组统计次数
        for (int value : array) {
            if (value == array[index]) {
                count++;
            }
        }
        //返回是否超过一半
        return count << 1 > array.length;
    }
    /**
     * 检查数组
     * @param array   数组
     * @return
     */
    private boolean checkInvalidArray(int[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 划分子数组
     * @param array   数组
     * @param start     起始点
     * @param end       终点
     * @return  标志值位置
     */
    private int partition(int[] array, int start, int end) {
        if (array == null || array.length == 0 || start < 0 || end >= array.length) {
            return 0;
        }
        if (start >= end) {
            return start;
        }
        //产生范围内的随机指标
        int index = randomInRange(start, end);
        //把这个标志值放在数组最后
        swap(array, end, index);
        //初始化指标i,i表示小于标志值的子数组的最后一个数的下标，初始值是-1
        int i = start-1;
        for (int j = start; j < array.length - 1; j++) {
            //如果当前值小于标志值
            if (array[j] < array[end]) {
                //小的子数组指标进1
                i++;
                //把当前值放在左子数组的最后一位
                swap(array, i, j);
            }
        }
        //遍历结束，把标识值放在左子数组的最后
        i++;
        swap(array, i, end);
        return i;
    }

    /**
     * 范围内的随机数
     * @param start 开始点
     * @param end   结束点
     * @return  返回随机数
     */
    private int randomInRange(int start, int end) {
        return (new Random().nextInt(end - start)+1) + start;
    }

    /**
     * 交换
     * @param array
     * @param first
     * @param second
     */
    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

}
