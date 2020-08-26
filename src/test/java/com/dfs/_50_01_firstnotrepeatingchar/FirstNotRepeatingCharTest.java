package com.dfs._50_01_firstnotrepeatingchar;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/19
 */
class FirstNotRepeatingCharTest {
    /**
     * 创建实例
     */
    FirstNotRepeatingChar firstNotRepeatingChar = new FirstNotRepeatingChar();
    @Test
    void firstNotRepeatingChar() {
        test1();
       /* String ster = "a";*/
    }

    void test(String testName, String string, int expected) {
        System.out.println(testName + ": begins!");
        int res = firstNotRepeatingChar.FirstNotRepeatingChar(string);
        if (res == expected) {
            System.out.println(testName + "  passed!");
        } else {
            System.out.println(testName + "  failed!");
        }
    }

    void test1() {
        test("test1", "google", 4);
    }
}
