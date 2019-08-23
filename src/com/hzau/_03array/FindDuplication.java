package com.hzau._03array;
/**
 * 面试题3（一）：找出数组中重复的数字
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是重复的数字2或者3。
 */

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/25 15:45
 */
public class FindDuplication {
    /**
     * 查询出任意一个重复的值
     * @param numbers 查询的数组
     * @return 如果查询到重复值，直接返回重复值，如果没有，返回-1
     */
    public int duplication(int[] numbers) {
        //排除空指针
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        //遍历查询数组中的数是否越界，如果越界直接返回-1
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) {
                return -1;
            }
        }

        //遍历查询
        for (int i = 0; i < numbers.length; i++) {
            //如果当前位置的下标不等于当前值
            while (numbers[i] != i) {
                //判断以当前值为下标的值是否等于当前值
                if (numbers[numbers[i]] == numbers[i]) {
                    return numbers[i];
                }

                //如果不等于，两者交换
                //通过这个交换，不断把数值放在下标等于其数值的位置上
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }
        //最后如果还是没有查询到重复值，返回-1
        return -1;
    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        //排除空指针
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        //遍历查询数组中的数是否越界，如果越界直接返回-1
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) {
                return false;
            }
        }

        //遍历查询
        for (int i = 0; i < numbers.length; i++) {
            //如果当前位置的下标不等于当前值
            while (numbers[i] != i) {
                //判断以当前值为下标的值是否等于当前值
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }

                //如果不等于，两者交换
                //通过这个交换，不断把数值放在下标等于其数值的位置上
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }
        //最后如果还是没有查询到重复值，返回-1
        return false;
    }

}
