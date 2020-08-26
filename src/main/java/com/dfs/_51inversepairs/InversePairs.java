package com.dfs._51inversepairs;

import java.util.Arrays;

/**
 * @description:    面试题51:数组中的逆序对
 * @author: Dafengsu
 * @date: 2019/8/19
 */
public class InversePairs {
    /**
     * 数据范围有限
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] resArray = new int[200000];
        int[] numbers = new int[200000];
        int res = 0;
        Arrays.fill(resArray, 0);
        Arrays.fill(numbers, 0);
        for (int value : array) {
            numbers[value]++;
            for (int i = value + 1; i < 200000; i++) {
                resArray[i] += numbers[i];
                resArray[i] %= 1000000007;
            }
        }
        for (int value : resArray) {
            res += value;
            res %= 1000000007;
        }
        return res  % 1000000007;
    }

    /**
     * 利用归并排序进行排序并统计
     * @param array
     * @return
     */
    public int InversePairs2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return mergerSortCore(array, 0, array.length - 1, new int[array.length]);

    }

    private int mergerSortCore(int[] array, int start, int end, int[] temp) {
        if (start == end) {
            return 0;
        }
        int mid = (end - start) / 2 + start;
        int left = mergerSortCore(array, start, mid, temp);
        int right = mergerSortCore(array, mid + 1, end, temp);
        int count = mergerSortMerge(array, start, mid, end, temp);
        return (left + right + count)%1000000007;
    }
    private int mergerSortMerge(int[] array, int start, int mid, int end, int[] temp) {
        System.arraycopy(array, start, temp, 0, end - start + 1);
        int left = 0;
        int right = mid - start + 1;
        int index = start;
        int count = 0;
        while (left <= mid - start && right <= end - start) {
            if (temp[left] <= temp[right]) {
                array[index++] = temp[left++];
            } else {
                array[index++] = temp[right++];
                count += mid - start - left + 1;
                count %= 1000000007;
            }
        }
        while (left <= mid - start) {
            array[index++] = temp[left++];
        }
        while (right <= end - start) {
            array[index++] = temp[right++];
        }
        return count%1000000007;
    }


}
