package com.hzau._47maxvalueofgifts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/19
 */
class MaxValueOfGiftsTest {
    /**
     * 创建实例
     */
    MaxValueOfGifts maxValueOfGifts = new MaxValueOfGifts();

    @Test
    void getMaxValue() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();

    }

    void test(String testName, int[][] arrays, int expected) {
        System.out.println(testName + ": begins");
        int res = maxValueOfGifts.getMaxValue2(arrays);
        if (res == expected) {
            System.out.println(testName + "  passed!");
        } else {
            System.out.println(testName + "  failed");
        }
    }

    void test1()
    {
        int[][] values = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int expected = 29;
        test("test1",values,expected);
    }

    void test2()
    {
        //四行四列
        int values[][] = {
                { 1, 10, 3, 8 },
                { 12, 2, 9, 6 },
                { 5, 7, 4, 11 },
                { 3, 7, 16, 5 }
        };
        int expected = 53;
        test("test2", values, expected);
    }

    void test3()
    {
        // 一行四列
        int values[][] = {
                { 1, 10, 3, 8 }
        };
        int expected = 22;
        test("test3",  values, expected);
    }

    void test4()
    {
        int values[][] = {
                { 1 },
                { 12 },
                { 5 },
                { 3 }
        };
        int expected = 21;
        test("test4", values, expected);
    }

    void test5()
    {
        // 一行一列
        int values[][] = {
                { 3 }
        };
        int expected = 3;
        test("test5",  values, expected);
    }

    void test6()
    {
        // 空指针
        int expected = 0;
        test("test6", null, expected);
    }
}