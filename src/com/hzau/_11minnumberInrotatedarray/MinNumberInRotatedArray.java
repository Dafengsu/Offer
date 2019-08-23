package com.hzau._11minnumberInrotatedarray;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/31
 */
public class MinNumberInRotatedArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }

        int index1 = 0;
        int index2 = array.length - 1;
        int mid = index1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                mid = index2;
            }
            mid = (index1 + index2) / 2;
            //如果三个是都相等只能顺序查找
            if (array[index1] == array[index2] && array[mid] == array[index1]) {
                return minInOrder(array, index1, index2);
            }
            if (array[mid] >= array[index1]) {
                index1 = mid;
            } else {
                index2 = mid;
            }
        }
        return array[mid];
    }

    private int minInOrder(int[] arr, int index1, int index2) {
        int results = arr[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (arr[i] < results) {
                results = arr[i];
            }
        }
        return results;
    }



}
