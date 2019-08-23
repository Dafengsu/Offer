package com.hzau._53_03_integeridenticaltoindex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/20
 */
class IntegerIdenticalToIndexTest {
    /**
     * 创建实例
     */
    IntegerIdenticalToIndex integerIdenticalToIndex = new IntegerIdenticalToIndex();

    @Test
    void getNumberSameAsIndex() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    void test(String testName, int[] array, int expected) {
        System.out.println(testName + ": begins");
        int res = integerIdenticalToIndex.getNumberSameAsIndex(array);
        if (res == expected) {
            System.out.println(testName + " passed!");
        } else {
            System.out.println(testName + "  failed!");
        }
    }
    void test1()
    {
        int[] numbers = { -3, -1, 1, 3, 5 };
        int expected = 3;
        test("test1", numbers,  expected);
    }

    void test2()
    {
        int numbers[] = { 0, 1, 3, 5, 6 };
        int expected = 0;
        test("test2", numbers,  expected);
    }

    void test3()
    {
        int[] numbers = { -1, 0, 1, 2, 4 };
        int expected = 4;
        test("test3", numbers,  expected);
    }

    void test4()
    {
        int[] numbers = { -1, 0, 1, 2, 5 };
        int expected = -1;
        test("test4", numbers,  expected);
    }

    void test5()
    {
        int[] numbers = { 0 };
        int expected = 0;
        test("test5", numbers,  expected);
    }

    void test6()
    {
        int[] numbers = { 10 };
        int expected = -1;
        test("test6", numbers,  expected);
    }

    void test7()
    {
        test("test7", null, -1);
    }
}