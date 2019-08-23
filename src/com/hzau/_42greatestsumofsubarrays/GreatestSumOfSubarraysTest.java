package com.hzau._42greatestsumofsubarrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/17
 */
class GreatestSumOfSubarraysTest {
    /**
     * 创建实例
     */
    GreatestSumOfSubarrays greatestSumOfSubarrays = new GreatestSumOfSubarrays();

    @Test
    void findGreatestSumOfSubArray() {
        int[] array = {-2,-8,-1,-5,-9};
        int res = greatestSumOfSubarrays.findGreatestSumOfSubArray2(array);
        System.out.println(res);
    }
}