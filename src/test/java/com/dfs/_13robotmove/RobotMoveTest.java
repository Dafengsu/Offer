package com.dfs._13robotmove;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/1
 */
class RobotMoveTest {
    RobotMove robotMove = new RobotMove();

    @Test
    void movingCount() {
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

    /*=======================================测试代码===============================*/

    /**
     * 测试方法
     * @param testName 测试名
     * @param threshold 限制值
     * @param rows      总行数
     * @param cols      总列数
     * @param expected  预期值
     */
    private void test(String testName, int threshold, int rows, int cols, int expected) {
        if (testName != null) {
            System.out.printf("%s begins", testName);
        }

        if (robotMove.movingCount(threshold, rows, cols) == expected) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
    }

    //方格多列多行
    private void test1() {
        test("Test1", 5, 10, 10, 21);
    }

    // 方格多行多列
    void test2()
    {
        test("Test2", 15, 20, 20, 359);
    }

    // 方格只有一行，机器人只能到达部分方格
    void test3()
    {
        test("Test3", 10, 1, 100, 29);
    }

    // 方格只有一行，机器人能到达所有方格
    void test4()
    {
        test("Test4", 10, 1, 10, 10);
    }

    // 方格只有一列，机器人只能到达部分方格
    void test5()
    {
        test("Test5", 15, 100, 1, 79);
    }

    // 方格只有一列，机器人能到达所有方格
    void test6()
    {
        test("Test6", 15, 10, 1, 10);
    }

    // 方格只有一行一列
    void test7()
    {
        test("Test7", 15, 1, 1, 1);
    }

    // 方格只有一行一列
    void test8()
    {
        test("Test8", 0, 1, 1, 1);
    }

    // 机器人不能进入任意一个方格
    void test9()
    {
        test("Test9", -10, 10, 10, 0);
    }

}
