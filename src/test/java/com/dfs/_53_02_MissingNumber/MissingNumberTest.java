package com.dfs._53_02_MissingNumber;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/20
 */
class MissingNumbertest {
    /**
     * 创建实例
     */
    MissingNumber missingNumber = new MissingNumber();

    @Test
    void getMissedNumber() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    void test(String testName, int[] array, int expected) {
        System.out.println(testName + ": begins");
        int res = missingNumber.getMissedNumber(array);
        if (res == expected) {
            System.out.println(testName + " passed!");
        } else {
            System.out.println(testName + "  failed!");
        }
    }

    // 缺失的是第一个数字0
    void test1()
    {
        int[] numbers = { 1, 2, 3, 4, 5 };
        int expected = 0;
        test("test1", numbers,  expected);
    }

    // 缺失的是最后一个数字
    void test2()
    {
        int[] numbers = { 0, 1, 2, 3, 4 };
        int expected = 5;
        test("test2", numbers,  expected);
    }

    // 缺失的是中间某个数字0
    void test3()
    {
        int[] numbers = { 0, 1, 2, 4, 5 };
        int expected = 3;
        test("test3", numbers,  expected);
    }

    // 数组中只有一个数字，缺失的是第一个数字0
    void test4()
    {
        int[] numbers = { 1 };
        int expected = 0;
        test("test4", numbers,  expected);
    }

    // 数组中只有一个数字，缺失的是最后一个数字1
    void test5()
    {
        int[] numbers = { 0 };
        int expected = 1;
        test("test5", numbers,  expected);
    }

    // 空数组
    void test6()
    {
        int expected = -1;
        test("test6", null, expected);
    }

}
