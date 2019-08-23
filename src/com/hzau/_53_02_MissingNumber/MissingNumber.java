package com.hzau._53_02_MissingNumber;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/20
 */
public class MissingNumber {
    public int getMissedNumber(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        int midIndex;
        int midData;
        while (start <= end) {
            midIndex = (start + end) / 2;
            midData = array[midIndex];
            if (midData != midIndex) {
                if (midIndex == 0 || (array[midIndex - 1] == midIndex - 1)) {
                    return midIndex;
                } else {
                    end = midIndex - 1;
                }
            } else {
                start = midIndex + 1;
            }
        }
        if (end == array.length-1) {
            return end + 1;
        }
        return -1;
    }

}
