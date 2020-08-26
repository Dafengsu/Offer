package com.dfs._31stackpushpoporder;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/8
 */
class StackPushPopOrderTest {
    /**
     * 创建实例
     */
    StackPushPopOrder stackPushPopOrder = new StackPushPopOrder();

    @Test
    void isPopOrder() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

    void test(String testName, int[] push, int[] pop, boolean expected) {
        if (testName != null) {
            System.out.println(testName + " begins:");
        }
        if (stackPushPopOrder.isPopOrder(push, pop) == expected) {
            System.out.println("Passed.");
        } else {
            System.out.println("failed.");
        }
    }

    void test1()
    {

        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};

        test("test1", push, pop, true);
    }

    void test2()
    {

        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {3, 5, 4, 2, 1};

        test("test2", push, pop, true);
    }

    void test3()
    {

        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3, 5, 1, 2};

        test("test3", push, pop, false);
    }

    void test4()
    {

        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {3, 5, 4, 1, 2};

        test("test4", push, pop, false);
    }

    /**
     *  push和pop序列只有一个数字
     */
    void test5()
    {
        int nLength = 1;
        int[] push = {1};
        int[] pop = {2};

        test("test5", push, pop, false);
    }

    void test6()
    {
        int nLength = 1;
        int[] push = {1};
        int[] pop = {1};

        test("test6", push, pop, true);
    }

    void test7()
    {
        test("test7", null, null, false);
    }
}
