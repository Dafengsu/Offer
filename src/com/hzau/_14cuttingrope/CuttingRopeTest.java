package com.hzau._14cuttingrope;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/1
 */
class CuttingRopeTest {
    //创建实例
    CuttingRope cuttingRope = new CuttingRope();
    @Test
    void maxProductAfterCutting() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
    }

    /**
     * 测试算法
     * @param testName 测试名称
     * @param length    绳子长度
     * @param expected  预期结果
     */
    void test(String testName, int length, int expected) {
        int res1 = cuttingRope.maxProductAfterCutting(length);
        if (res1 == expected) {
            System.out.println("Solution1 for" + testName + "passed.");
        } else {
            System.out.println("Solution1 for" + testName + "failed.");
        }

        int res2 = cuttingRope.maxProductAfterCutting2(length);
        if (res2 == expected) {
            System.out.println("Solution2 for" + testName + "passed.");
        } else {
            System.out.println("Solution2 for" + testName + "failed.");
        }
    }

    void test1()
    {
        int length = 1;
        int expected = 0;
        test("test1", length, expected);
    }

    void test2()
    {
        int length = 2;
        int expected = 1;
        test("test2", length, expected);
    }

    void test3()
    {
        int length = 3;
        int expected = 2;
        test("test3", length, expected);
    }

    void test4()
    {
        int length = 4;
        int expected = 4;
        test("test4", length, expected);
    }

    void test5()
    {
        int length = 5;
        int expected = 6;
        test("test5", length, expected);
    }

    void test6()
    {
        int length = 6;
        int expected = 9;
        test("test6", length, expected);
    }

    void test7()
    {
        int length = 7;
        int expected = 12;
        test("test7", length, expected);
    }

    void test8()
    {
        int length = 8;
        int expected = 18;
        test("test8", length, expected);
    }

    void test9()
    {
        int length = 9;
        int expected = 27;
        test("test9", length, expected);
    }

    void test10()
    {
        int length = 10;
        int expected = 36;
        test("test10", length, expected);
    }

    void test11()
    {
        int length = 50;
        int expected = 86093442;
        test("test11", length, expected);
    }
}