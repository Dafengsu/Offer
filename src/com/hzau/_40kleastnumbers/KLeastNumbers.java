package com.hzau._40kleastnumbers;

import java.util.*;

/**
 * @description:    面试题40：最小的k个数
 * @author: Dafengsu
 * @date: 2019/8/10
 */
public class KLeastNumbers {
   
    public ArrayList<Integer> getLeastNumbersSolution(int [] input, int k) {

        ArrayList<Integer> resList = new ArrayList<>();
        if (k > input.length || k == 0) {
            return resList;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.add(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.add(input[i]);
            }
        }
        resList.addAll(maxHeap);
        return resList;
    }

}
