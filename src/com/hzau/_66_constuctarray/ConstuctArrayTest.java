package com.hzau._66_constuctarray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/23
 */
class ConstuctArrayTest {
    /**
     * 创建实例
     */
    ConstuctArray constuctArray = new ConstuctArray();
    @Test
    void multiply() {
        int[] A = {1, 2, 3, 4, 5};
        int[] res = constuctArray.multiply(A);
        System.out.println(Arrays.toString(res));
    }
}