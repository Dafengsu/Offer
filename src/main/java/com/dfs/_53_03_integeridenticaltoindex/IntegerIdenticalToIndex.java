package com.dfs._53_03_integeridenticaltoindex;

/**
 * @description:    面试题53-3：数组中数值和下标相等的元素
 * @author: Dafengsu
 * @date: 2019/8/20
 */
public class IntegerIdenticalToIndex {
    public int getNumberSameAsIndex(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length;
        int midIndex;
        int midData;
        while (start <= end) {
            midIndex =(start + end)>>1;
            midData = array[midIndex];
            if (midIndex == midData) {
                return midData;
            } else if (midIndex < midData) {
                end = midIndex - 1;
            } else {
                start = midIndex + 1;
            }
        }
        return -1;
    }
}
