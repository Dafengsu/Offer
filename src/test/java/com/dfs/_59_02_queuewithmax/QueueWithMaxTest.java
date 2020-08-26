package com.dfs._59_02_queuewithmax;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/22
 */
class QueueWithMaxTest {
    @Test
    void testMain() {
        QueueWithMax queue = new QueueWithMax();
        // {2}
        queue.push(2);
        test("test1", queue, 2);

        // {2, 3}
        queue.push(3);
        test("test2", queue, 3);

        // {2, 3, 4}
        queue.push(4);
        test("test3", queue, 4);

        // {2, 3, 4, 2}
        queue.push(2);
        test("test4", queue, 4);

        // {3, 4, 2}
        queue.pop();
        test("test5", queue, 4);

        // {4, 2}
        queue.pop();
        test("test6", queue, 4);

        // {2}
        queue.pop();
        test("test7", queue, 2);

        // {2, 6}
        queue.push(6);
        test("test8", queue, 6);

        // {2, 6, 2}
        queue.push(2);
        test("test9", queue, 6);

        // {2, 6, 2, 5}
        queue.push(5);
        test("test9", queue, 6);

        // {6, 2, 5}
        queue.pop();
        test("test10", queue, 6);

        // {2, 5}
        queue.pop();
        test("test11", queue, 5);

        // {5}
        queue.pop();
        test("test12", queue, 5);

        // {5, 1}
        queue.push(1);
        test("test13", queue, 5);
    }

    void test(String testName, QueueWithMax queue, int expected) {
        System.out.println(testName + ": begins");
        int res = queue.max();
        if (res == expected) {
            System.out.println(testName + " passed!");
        } else {
            System.out.println(testName + "  failed!");
        }
    }
}
