package com.hzau._59_01_maxInslidingwindow;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/22
 */
class MaxInSlidingWindowTest {
    /**
     * 创建实例
     */
    MaxInSlidingWindow maxInSlidingWindow = new MaxInSlidingWindow();

    @Test
    void maxInWindows() {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> res = maxInSlidingWindow.maxInWindows(num, 3);
        System.out.println(res);
    }
}