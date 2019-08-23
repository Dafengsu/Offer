package com.hzau._57_02_ContinuousSquenceWithSum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/21
 */
class ContinuousSquenceWithSumTest {
    /**
     * 创建实例
     */
    ContinuousSquenceWithSum continuousSquenceWithSum = new ContinuousSquenceWithSum();
    @Test
    void findContinuousSequence() {
        ArrayList<ArrayList<Integer>> res1 = continuousSquenceWithSum.FindContinuousSequence(6);
        ArrayList<ArrayList<Integer>> res2 = continuousSquenceWithSum.FindContinuousSequence2(6);
        System.out.println(res1);
        System.out.println(res2);
        /*long start1 = System.currentTimeMillis();*/

    }
}