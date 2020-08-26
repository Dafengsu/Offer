package com.dfs._44digitsInsequence;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/18
 */
class DigitsInSequenceTest {
    /**
     * 创建实例
     */
    DigitsInSequence digitsInSequence = new DigitsInSequence();

    @Test
    void digitAtIndex() {
        int res = digitsInSequence.digitAtIndex(1001);
        System.out.println(res);
    }
}
