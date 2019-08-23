package com.hzau._11minnumberInrotatedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/31
 */
class MinNumberInRotatedArrayTest {
    MinNumberInRotatedArray minNumberInRotatedArray = new MinNumberInRotatedArray();
    @Test
    void minNumberInRotateArray() {
        int[] arr = {1};
        int res = minNumberInRotatedArray.minNumberInRotateArray(arr);
        System.out.println(res);
    }
}