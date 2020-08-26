package com.dfs._46translatenumberstostrings;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/19
 */
class TranslateNumbersToStringsTest {
    /**
     * 创建实例
     */
    TranslateNumbersToStrings translateNumbersToStrings = new TranslateNumbersToStrings();

    @Test
    void getTranslationCount() {
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

    void test(String testName, int number, int expected) {
        System.out.println(testName + ": begins:");
        int res = translateNumbersToStrings.getTranslationCount2(number);
        if (res == expected) {
            System.out.println(testName + " passed!");
        } else {
            System.out.println(testName + " failed");
        }
    }
    void test1()
    {
        int number = 0;
        int expected = 1;
        test("test1", number, expected);
    }

    void test2()
    {
        int number = 10;
        int expected = 2;
        test("test2", number, expected);
    }

    void test3()
    {
        int number = 125;
        int expected = 3;
        test("test3", number, expected);
    }

    void test4()
    {
        int number = 126;
        int expected = 2;
        test("test4", number, expected);
    }

    void test5()
    {
        int number = 426;
        int expected = 1;
        test("test5", number, expected);
    }

    void test6()
    {
        int number = 100;
        int expected = 2;
        test("test6", number, expected);
    }

    void test7()
    {
        int number = 101;
        int expected = 2;
        test("test7", number, expected);
    }

    void test8()
    {
        int number = 12258;
        int expected = 5;
        test("test8", number, expected);
    }

    void test9()
    {
        int number = -100;
        int expected = 0;
        test("test9", number, expected);
    }
}
