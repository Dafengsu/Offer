package com.hzau._11minnumberInrotatedarray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/31
 */
class RandomQuickSortTest {
    RandomQuickSort quickSort = new RandomQuickSort();
    @Test
    void randomQuickSort() {

      /*  int[] arr1 = {4, 4, 9, 1};
        System.out.println(Arrays.toString(arr1));
        quickSort.randomQuickSort(arr1);
        System.out.println(Arrays.toString(arr1));*/
      /*  for (int j = 0; j < arr1.length - 1; j++) {
            if (arr1[j] > arr1[j + 1]) {
                System.out.println(Arrays.toString(arr1));

                throw new RuntimeException("第"+"次测试出错");
            }

        }*/


        for (int i = 0; i < 1000; i++) {
            int[] arr1 = new int[10];
            for (int j = 0; j < arr1.length; j++) {
                arr1[j] = new Random().nextInt(10);
            }
            int[] arrtemp = arr1.clone();
            quickSort.randomQuickSort(arr1);
            for (int j = 0; j < arr1.length - 1; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    System.out.println(Arrays.toString(arr1));
                    System.out.println(Arrays.toString(arrtemp));
                    throw new RuntimeException("第"+i+"次测试出错");
                }

            }
        }

    }

    @Test
    void test() {
        for (int i = 0; i < 100; i++) {
            int index = new Random().nextInt(100000);
            System.out.print(index + " ");
        }
    }

    @Test
    void ageSort() {
        for (int i = 0; i < 1000; i++) {
            int[] arr = new int[100];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = new Random().nextInt(100);
            }
            int[] arrtemp = arr.clone();
            quickSort.sortAges(arr);
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    System.out.println(Arrays.toString(arr));
                    System.out.println(Arrays.toString(arrtemp));
                    throw new RuntimeException("第"+i+"次测试出错");
                }

            }
        }
    }
}