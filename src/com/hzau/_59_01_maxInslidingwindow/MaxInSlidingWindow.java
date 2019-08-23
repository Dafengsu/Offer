package com.hzau._59_01_maxInslidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @description:    面试题59-1：滑动窗格的最大值
 * @author: Dafengsu
 * @date: 2019/8/22
 */
public class MaxInSlidingWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length < size || size < 1) {
            return res;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            if (i >= size) {
                res.add(num[deque.peek()]);
            }
            while (!deque.isEmpty() && num[i] > num[deque.peekLast()]) {
                deque.removeLast();
            }
            if (!deque.isEmpty() && deque.peek() <= i - size) {
                deque.removeFirst();
            }
            deque.add(i);
        }
        res.add(num[deque.peek()]);
        return res;
    }
}
