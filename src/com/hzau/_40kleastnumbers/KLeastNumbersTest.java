package com.hzau._40kleastnumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/10
 */
class KLeastNumbersTest {
    /**
     * 创建实例
     */
    KLeastNumbers kLeastNumbers = new KLeastNumbers();

    @Test
    void getLeastNumbersSolution() {
        int[] numbers = {2, 3, 4, 5, 1, 2, 23, 234, 234, 1, 23};
        kLeastNumbers.getLeastNumbersSolution(numbers, 3);
    }
}