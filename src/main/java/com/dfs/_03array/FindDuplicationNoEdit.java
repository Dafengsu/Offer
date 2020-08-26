package com.dfs._03array;
/**
 *  面试题3（二）：不修改数组找出重复的数字
 *  题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
 *  少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
 *  数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
 *  输出是重复的数字2或者3。
 *
 * @author: Dafengsu
 * @date: 2019/7/25
 */
public class FindDuplicationNoEdit {
    /**
     * 不改变数组的基础上，查找重复值（采用类似二分查找的方法）
     * @param numbers 传入的数组
     * @return 如果找到，返回数值，没找到返回-1，数组的数值大小越界或者数组为空直接返回-1
     */
    public int duplication(int[] numbers) {
        //判断数组是否为空
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        //数组长度
        int length = numbers.length;
        //起点值
        int start = 0;
        //终点值
        int end = length - 1;
        //中点值
        int mid;

        //判断数组数值是否越界
        for (int number : numbers) {
            if (number < 0 || number > length - 1) {
                return -1;
            }
        }

        //执行二分查找
        while (start <= end) {
            //取中点值
            mid = (end - start >> 1)+start;
            //计算范围类的数值数
            int count = countRange(numbers, start, mid);
            //起点值和终点值相遇，判断是否有重复值
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            //判断重复值在给定数值范围类的前半段还是后半段
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }

    /**
     * 计算数组中数值在start到end之间的数量
     *
     * @param numbers 数组
     * @param start   起始点
     * @param end     中点
     * @return 统计数值
     */
    private int countRange(int[] numbers, int start, int end) {
        //如果数组为空，直接返回0
        if (numbers == null) {
            return 0;
        }
        int count = 0;
        //遍历查询
        for (int number : numbers) {
            if (number >= start && number <= end) {
                ++count;
            }
        }
        return count;
    }
}
