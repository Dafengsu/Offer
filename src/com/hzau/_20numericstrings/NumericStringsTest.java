package com.hzau._20numericstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/7
 */
class NumericStringsTest {
    /**
     * 创建实例
     */
    NumericStrings numericStrings = new NumericStrings();

    @Test
    void isNumeric() {
        char[] str = {'1', '0', '0'};
        boolean numeric = numericStrings.isNumeric(str);
        System.out.println(numeric);
    }
}