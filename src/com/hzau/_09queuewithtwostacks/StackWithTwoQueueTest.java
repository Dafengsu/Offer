package com.hzau._09queuewithtwostacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/31
 */
class StackWithTwoQueueTest {
    @Test
    void test() {
        StackWithTwoQueue stack = new StackWithTwoQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
        int res = stack.pop();
        System.out.println(res);
    }
}