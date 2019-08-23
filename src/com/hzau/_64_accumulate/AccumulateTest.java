package com.hzau._64_accumulate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/22
 */
class AccumulateTest {
    /**
     * 创建实例
     */
    Accumulate accumulate = new Accumulate();
    @Test
    void sum2() {
        int res = accumulate.sum(5);
        System.out.println(res);
    }
}