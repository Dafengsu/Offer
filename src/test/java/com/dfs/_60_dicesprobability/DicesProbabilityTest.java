package com.dfs._60_dicesprobability;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/22
 */
class DicesProbabilityTest {

    /**
     * 创建实例
     */
    DicesProbability dicesProbability = new DicesProbability();

    @Test
    void dicesProbability() {
        double[] res = dicesProbability.dicesProbability2(2);
        System.out.println(Arrays.toString(res));
    }
}
