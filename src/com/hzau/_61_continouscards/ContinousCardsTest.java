package com.hzau._61_continouscards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/22
 */
class ContinousCardsTest {
    /**
     * 创建实例
     */
    ContinousCards continousCards = new ContinousCards();

    @Test
    void isContinuous() {
        int[] numbers = {1, 3, 2, 5, 4};
        boolean res = continousCards.isContinuous3(numbers);
        System.out.println(res);
    }
}