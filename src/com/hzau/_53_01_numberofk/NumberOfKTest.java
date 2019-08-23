package com.hzau._53_01_numberofk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/20
 */
class NumberOfKTest {
    /**
     * 创建实例
     */
    NumberOfK numberOfK = new NumberOfK();
    @Test
    void getNumberOfK() {
        test1();
    }

    void test(String testName, int[] array, int k, int expected) {

        System.out.println(testName + ": begins");
        int res = numberOfK.GetNumberOfK2(array, k);
        if (res == expected) {
            System.out.println(testName + " passed!");
        } else {
            System.out.println(testName + "  failed!");
        }
    }

    void test1() {
        int[] array = {1,2,3,3,3,3};
        int k = 3;
        int expected = 4;
        test("test1", array, k, expected);
    }
}