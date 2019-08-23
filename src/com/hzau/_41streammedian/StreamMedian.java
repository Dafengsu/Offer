package com.hzau._41streammedian;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description:    面试41：数据流中的中位数
 * @author: Dafengsu
 * @date: 2019/8/17
 */
public class StreamMedian {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    int length = 0;

    /**
     * 插入数据
     * @param num
     */
    public void insert(Integer num) {
        length++;
        if ((length & 1) == 0) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());

        }
    }

    /**
     * 获取中位值
     * @return
     */
    public Double getMedian() {
        double results;
        if ((length & 1) == 1) {
            results = maxHeap.peek();
        } else {
            results = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return results;
    }
}
