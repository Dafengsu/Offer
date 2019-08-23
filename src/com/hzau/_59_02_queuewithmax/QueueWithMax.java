package com.hzau._59_02_queuewithmax;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 面试题59_2:队列的最大值
 * @author: Dafengsu
 * @date: 2019/8/22
 */
public class QueueWithMax {
    static class InternalData {
        int number;
        int index;

        InternalData(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }

    private Deque<InternalData> data;
    private Deque<InternalData> maximums;
    private int currentIndex;
    public QueueWithMax() {
        data = new ArrayDeque<>();
        maximums = new ArrayDeque<>();
        currentIndex = 0;
    }

    public void push(int num) {
        while (!maximums.isEmpty() && num >= maximums.peekLast().number) {
            maximums.removeLast();
        }
        InternalData internalData = new InternalData(num, currentIndex);
        data.add(internalData);
        maximums.add(internalData);
        currentIndex++;
    }

    public int pop() {
        if (maximums.isEmpty() || data.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        if (maximums.peek().index == data.peek().index) {
            maximums.poll();
        }
        return data.poll().number;
    }

    public int max() {
        if (maximums.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return maximums.peek().number;
    }
}
