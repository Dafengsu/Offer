package com.dfs._48longestsubstringwithoutdup;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/19
 */
class LongestSubstringWithoutDupTest {
    /**
     * 创建实例
     */
    LongestSubstringWithoutDup longestSubstringWithoutDup = new LongestSubstringWithoutDup();
    @Test
    void longestSubstringWithoutDuplication() {
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
    }

    void test(String testName, String string, int expected) {
        System.out.println(testName + ": begins");
        int res = longestSubstringWithoutDup.longestSubstringWithoutDuplication(string);
        if (res == expected) {
            System.out.println(testName + "  passed!");
        } else {
            System.out.println(testName + "  failed");
        }
    }

    void test1()
    {
    String input = "abcacfrar";
        int expected = 4;
        test("test1",input, expected);
    }

    void test2()
    {
    String input = "acfrarabc";
        int expected = 4;
        test("test2",input, expected);
    }

    void test3()
    {
    String input = "arabcacfr";
        int expected = 4;
        test("test3",input, expected);
    }

    void test4()
    {
    String input = "aaaa";
        int expected = 1;
        test("test4",input, expected);
    }

    void test5()
    {
    String input = "abcdefg";
        int expected = 7;
        test("test5",input, expected);
    }

    void test6()
    {
    String input = "aaabbbccc";
        int expected = 2;
        test("test6",input, expected);
    }

    void test7()
    {
    String input = "abcdcba";
        int expected = 4;
        test("test7",input, expected);
    }

    void test8()
    {
    String input = "abcdaef";
        int expected = 6;
        test("test8",input, expected);
    }

    void test9()
    {
    String input = "a";
        int expected = 1;
        test("test9",input, expected);
    }

    void test10()
    {
    String input = "";
        int expected = 0;
        test("test10",input, expected);
    }
}
