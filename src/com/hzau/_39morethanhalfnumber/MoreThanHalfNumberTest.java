package com.hzau._39morethanhalfnumber;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/10
 */
class MoreThanHalfNumberTest {
    /**
     * 创建实例
     */
    MoreThanHalfNumber moreThanHalfNumber = new MoreThanHalfNumber();
    @Test
    void moreThanHalfNumSolution() {
        int[] array = {1};
        int res = moreThanHalfNumber.moreThanHalfNumSolution(array);
        System.out.println(res);
    }
}