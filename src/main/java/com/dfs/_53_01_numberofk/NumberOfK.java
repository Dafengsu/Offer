package com.dfs._53_01_numberofk;

/**
 * @description:    面试题：53-1:数字在排序数组中出现的次数
 * @author: Dafengsu
 * @date: 2019/8/20
 */
public class NumberOfK {
    /**
     * 递归求解
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int first = getFirstK(array, k, 0, array.length - 1);
        int last = getLastK(array, k, 0, array.length - 1);
        if (first == -1 || last == -1) {
            return 0;
        }
        return last - first + 1;
    }

    private int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midData = array[midIndex];
        if (midData == k) {
            if (midIndex == 0||(midIndex > 0 && array[midIndex - 1] != k) ) {
                return midIndex;
            } else {
                end = midIndex - 1;
            }
        } else if (k < midData) {
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }

        return getFirstK(array, k, start, end);
    }

    private int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midData = array[midIndex];
        if (k == midData) {
            if (midIndex == end||(midIndex > -1 && array[midIndex + 1] != k) ) {
                return midIndex;
            } else {
                start = midIndex + 1;
            }
        } else if (k < midData) {
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }

        return getLastK(array, k, start, end);
    }

    /**
     * 循环求解
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK2(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int first = getFirstK2(array, k);
        int last = getLastK2(array, k);

        if (first == -1 || last == -1) {
            return 0;
        }
        return last - first + 1;
    }
    private int getFirstK2(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        int midIndex;
        int midData;
        while (start <= end) {
            midIndex = (start + end) / 2;
            midData = array[midIndex];
            if (k == midData) {
                if (midIndex == 0 || (array[midIndex - 1] != k)) {
                    return midIndex;
                } else {
                    end = midIndex - 1;
                }
            } else if (k < midData) {
                end = midIndex - 1;
            } else {
                start = midIndex + 1;
            }
        }
        return -1;

    }

    private int getLastK2(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        int midIndex;
        int midData;
        while (start <= end) {
            midIndex = (start + end) / 2;
            midData = array[midIndex];
            if (k == midData) {
                if (midIndex == array.length - 1 || (array[midIndex + 1] != k)) {
                    return midIndex;
                } else {
                    start = midIndex + 1;
                }
            } else if (k < midData) {
                end = midIndex - 1;
            } else {
                start = midIndex + 1;
            }
        }
        return -1;
    }
}
