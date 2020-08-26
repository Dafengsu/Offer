package com.dfs._56_01_numbersappearonce;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/21
 */
class NumbersAppearOnceTest {
    /**
     * 创建实例
     */
    NumbersAppearOnce numbersAppearOnce = new NumbersAppearOnce();

    @Test
    void findNumbersAppearOnce() {
        int[] array = { 4, 6, 1, 1, 1, 1 };
        ArrayList<Integer> res = this.numbersAppearOnce.findNumbersAppearOnce(array);
        System.out.println(res);
    }
}
