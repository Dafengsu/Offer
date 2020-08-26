package com.dfs._41streammedian;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/17
 */
class StreamMedianTest {
    /**
     * 创建实例
     */
    StreamMedian streamMedian = new StreamMedian();
    @Test
    void test() {
        int[] array = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            streamMedian.insert(array[i]);
            result[i] = streamMedian.getMedian();
        }
        System.out.println(Arrays.toString(result));
    }

}
