package com.dfs._16power;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/3
 */
class PowerTest {
    //创建一个实例
    Power power = new Power();
    @Test
    void pow() {
        double results = power.pow(2, 10);
        System.out.println(results);
    }
}
