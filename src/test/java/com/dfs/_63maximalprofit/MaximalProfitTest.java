package com.dfs._63maximalprofit;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/22
 */
class MaximalProfitTest {
    /**
     * 创建实例
     */
    MaximalProfit maximalProfit = new MaximalProfit();

    @Test
    void maxDiff() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    void test(String testName, int[] array, int expected) {
        System.out.println(testName + ": begins");
        int res = maximalProfit.maxDiff(array);
        if (res == expected) {
            System.out.println(testName + " passed!");
        } else {
            System.out.println(testName + "  failed!");
        }
    }

    void test1()
    {
        int[] numbers = { 4, 1, 3, 2, 5 };
        test("test1", numbers,  4);
    }

    // 价格递增
    void test2()
    {
        int[] numbers = { 1, 2, 4, 7, 11, 16 };
        test("test2", numbers,  15);
    }

    // 价格递减
    void test3()
    {
        int[] numbers = { 16, 11, 7, 4, 2, 1 };
        test("test3", numbers,  -1);
    }

    // 价格全部相同
    void test4()
    {
        int[] numbers = { 16, 16, 16, 16, 16 };
        test("test4", numbers,  0);
    }

    void test5()
    {
        int[] numbers = { 9, 11, 5, 7, 16, 1, 4, 2 };
        test("test5", numbers,  11);
    }

    void test6()
    {
        int[] numbers = { 2, 4 };
        test("test6", numbers,  2);
    }

    void test7()
    {
        int[] numbers = { 4, 2 };
        test("test7", numbers,  -2);
    }

    void test8()
    {
        test("test8", null, 0);
    }

}
