package com.hzau._58_02_leftrotatestring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/21
 */
class LeftRotateStringTest {
    /**
     * 创建实例
     */
    LeftRotateString leftRotateString = new LeftRotateString();

    @Test
    void leftRotateString() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    void test(String testName, String string, int n, String expected) {
        System.out.println(testName + ": begins");
        String res = leftRotateString.LeftRotateString(string, n);
        if ((res==expected)||res.equals(expected)) {
            System.out.println(testName + " passed!");
        } else {
            System.out.println(testName + "  failed!");
        }
    }

    // 功能测试
    void test1()
    {
        String input = "abcdefg";
        String expected = "cdefgab";

        test("test1", input, 2, expected);
    }

    // 边界值测试
    void test2()
    {
        String input = "abcdefg";
        String expected = "bcdefga";

        test("test2", input, 1, expected);
    }

    // 边界值测试
    void test3()
    {
        String input = "abcdefg";
        String expected = "gabcdef";

        test("test3", input, 6, expected);
    }

    // 鲁棒性测试
    void test4()
    {
        test("test4", null, 6, null);
    }

    // 鲁棒性测试
    void test5()
    {
        String input = "abcdefg";
        String expected = "abcdefg";

        test("test5", input, 0, expected);
    }

    // 鲁棒性测试
    void test6()
    {
        String input = "abcdefg";
        String expected = "abcdefg";

        test("test6", input, 7, expected);
    }
}