package com.dfs._11minnumberInrotatedarray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/31
 */
class QuickSortTest {
    QuickSort quickSort = new QuickSort();

    @Test
    void quickSort() {
        //测试一万次
        for (int n = 0; n < 10000; n++) {
            for (int i = 0; i < 1000; i++) {
                int[] arr = new int[10];
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = new Random().nextInt(10);
                }
                int[] arrtemp = arr;
                quickSort.quickSort(arr);
                for (int j = 0; j < arr.length - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        System.out.println(Arrays.toString(arr));
                        System.out.println(Arrays.toString(arrtemp));
                        throw new RuntimeException("测试出错");
                    }

                }
            }
        }
        int[] arr = {0, 2, 2, 2, 4, 5, 4, 5, 7, 9};
        quickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
