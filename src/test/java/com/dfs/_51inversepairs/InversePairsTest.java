package com.dfs._51inversepairs;

import org.junit.jupiter.api.Test;

/**
 * @description
 * @author Dafengsu
 * @date 2019/8/19
 */
class InversePairsTest {
    /**
     * 创建实例
     */
    InversePairs inversePairs = new InversePairs();

    @Test
    void inversePairs() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    void test(String testName, int[] arrays, int expected) {
        System.out.println(testName + ": begins");
        int res = inversePairs.InversePairs2(arrays);
        if (res == expected) {
            System.out.println(testName + " passed!");
        } else {
            System.out.println(testName + "  failed!");
        }
    }

    void test1()
    {
        int[] data = { 1, 2, 3, 4, 7, 6, 5 };
        int expected = 3;

        test("test1", data, expected);
    }

    // 递减排序数组
    void test2()
    {
        int[] data = { 6, 5, 4, 3, 2, 1 };
        int expected = 15;

        test("test2", data, expected);
    }

    // 递增排序数组
    void test3()
    {
        int[] data = { 1, 2, 3, 4, 5, 6 };
        int expected = 0;

        test("test3", data, expected);
    }

    // 数组中只有一个数字
    void test4()
    {
        int[] data = { 1 };
        int expected = 0;

        test("test4", data, expected);
    }


    // 数组中只有两个数字，递增排序
    void test5()
    {
        int[] data = { 1, 2 };
        int expected = 0;

        test("test5", data, expected);
    }

    // 数组中只有两个数字，递减排序
    void test6()
    {
        int[] data = { 2, 1 };
        int expected = 1;

        test("test6", data, expected);
    }

    // 数组中有相等的数字
    void test7()
    {
        int[] data = { 1, 2, 1, 2, 1 };
        int expected = 3;

        test("test7", data, expected);
    }

    void test8()
    {
        int expected = 0;

        test("test8", null, expected);
    }
}
