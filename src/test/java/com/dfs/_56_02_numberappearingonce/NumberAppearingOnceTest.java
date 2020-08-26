package com.dfs._56_02_numberappearingonce;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/21
 */
class NumberAppearingOnceTest {
    /**
     * 创建实例
     */
    NumberAppearingOnce numberAppearingOnce = new NumberAppearingOnce();

    @Test
    void findNumberAppearingOnce() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
    }

    void test(String testName, int[] array, int expected) {
        System.out.println(testName + ": begins");
        int res = this.numberAppearingOnce.findNumberAppearingOnce(array);
        if (res == expected) {
            System.out.println(testName + " passed!");
        } else {
            System.out.println(testName + "  failed!");
        }
    }

    // 所有数字都是正数，唯一的数字是最小的
    void test1()
    {
        int[] numbers = { 1, 1, 2, 2, 2, 1, 3 };
        int expected = 3;
        test("test1", numbers,  expected);
    }

    // 所有数字都是正数，唯一的数字的大小位于中间
    void test2()
    {
        int[] numbers = { 4, 3, 3, 2, 2, 2, 3 };
        int expected = 4;
        test("test2", numbers,  expected);
    }

    // 所有数字都是正数，唯一的数字是最大的
    void test3()
    {
        int[] numbers = { 4, 4, 1, 1, 1, 7, 4 };
        int expected = 7;
        test("test3", numbers,  expected);
    }

    // 唯一的数字是负数
    void test4()
    {
        int[] numbers = { -10, 214, 214, 214 };
        int expected = -10;
        test("test4", numbers,  expected);
    }

    // 除了唯一的数字，其他数字都是负数
    void test5()
    {
        int[] numbers = { -209, 3467, -209, -209 };
        int expected = 3467;
        test("test5", numbers,  expected);
    }

    // 重复的数字有正数也有负数
    void test6()
    {
        int[] numbers = { 1024, -1025, 1024, -1025, 1024, -1025, 1023 };
        int expected = 1023;
        test("test6", numbers,  expected);
    }

    // 所有数字都是负数
    void test7()
    {
        int[] numbers = { -1024, -1024, -1024, -1023 };
        int expected = -1023;
        test("test7", numbers,  expected);
    }

    // 唯一的数字是0
    void test8()
    {
        int[] numbers = { -23, 0, 214, -23, 214, -23, 214 };
        int expected = 0;
        test("test8", numbers,  expected);
    }

    // 除了唯一的数字，其他数字都是0
    void test9()
    {
        int[] numbers = { 0, 3467, 0, 0, 0, 0, 0, 0 };
        int expected = 3467;
        test("test9", numbers,  expected);
    }
}
