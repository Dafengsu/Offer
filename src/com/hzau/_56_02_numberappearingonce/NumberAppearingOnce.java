package com.hzau._56_02_numberappearingonce;

import java.util.Arrays;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/21
 */
public class NumberAppearingOnce {
    public int findNumberAppearingOnce(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] bitSum = new int[32];
        Arrays.fill(bitSum, 0);
        int bitMark;
        int bit;
        for (int value : array) {
            bitMark = 1;
            for (int j = 31; j >= 0; j--) {
                bit = value & bitMark;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMark <<= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += bitSum[i] % 3;
        }
        return res;
    }
}
