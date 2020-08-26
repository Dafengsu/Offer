package com.dfs._11minnumberInrotatedarray;

import java.util.Random;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/31
 */
public class RandomQuickSort {
    public void randomQuickSort(int[] arr) {
        randomQuickSort(arr, 0, arr.length-1);
    }

    public void randomQuickSort(int[] arr, int start, int end) {
        //起点坐标和终点坐标没有相遇
        if (start < end) {
            //划分子数组
            int p = randomPartition(arr, start, end);
            //排序左子树
            randomQuickSort(arr, start, p - 1);
            //排序右子树
            randomQuickSort(arr, p + 1, end);
        }


    }

    public int randomPartition(int[] arr, int start, int end) {
        //随机取一个标识符
        int index = start + new Random().nextInt(end - start+1);
        int x = arr[index];
       /* System.out.println("起点:" + start + " 标识位:" + index + " 终点:" + end);*/
        //辅助值
        int temp;
        //把随机标识符放在数组的最后位置上
        temp = arr[end];
        arr[end] = x;
        arr[index] = temp;
        //第一个子数组的最后一个元素的小标（初始-1）
        int i = start - 1;

        //遍历分组
        for (int j = start; j < end; j++) {
            //如果当前值小于标识值，第一个子数组前进一位（i++),把当前值和i++
            //上的值交换
            if (arr[j] < x) {
                ++i;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //遍历结束，把标识值，放在小于标识值的子数组最后(与当前这个位置的值进行交换）
        temp = arr[i + 1];
        arr[i + 1] = x;
        arr[end] = temp;
        return i + 1;
    }

    void sortAges(int[] ages) {
        //排除数组为空
        if (ages == null || ages.length == 0) {
            return;
        }
        //获得数组长度
        int length = ages.length;
        //设置最大数值
        int oldestAge = 99;
        //创建一个年龄数组
        int[] timesofAge = new int[oldestAge + 1];
        //遍历数组，记录年龄数
        for (int i = 0; i < length; i++) {
            int age = ages[i];
            if (age < 0 || age > oldestAge) {
                throw new RuntimeException("age out of range");
            }
            ++timesofAge[age];
        }
        //辅助标签
        int index = 0;
        //遍历年龄数组
        for (int i = 0; i <= oldestAge; i++) {
            //此年龄有几次，就重新赋值几次
            for (int j = 0; j < timesofAge[i]; j++) {
                ages[index] = i;
                index++;
            }
        }
    }
}
