package com.hzau._15numberof1inbinary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/1
 */
class NumberOf1InBinaryTest {
    NumberOf1InBinary numberOf1InBinary = new NumberOf1InBinary();

    @Test
    void numberOf1() {
        int n = -2147483648;
        System.out.println(Integer.toBinaryString(n));
        int index1 = numberOf1InBinary.numberOf11(n);
        System.out.println(index1);
        int index2 = numberOf1InBinary.numberOf12(n);
        System.out.println(index2);
    }
}