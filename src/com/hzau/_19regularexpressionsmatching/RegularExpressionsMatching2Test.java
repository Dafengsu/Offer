package com.hzau._19regularexpressionsmatching;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/6
 */
class RegularExpressionsMatching2Test {
    /**
     * 创建实例
     */
    RegularExpressionsMatching regularExpressionsMatching2 = new RegularExpressionsMatching();

    @Test
    void match() {
        char[] str = {};
        char[] pattern = {'.'};
        boolean match = regularExpressionsMatching2.match(str, pattern);
        System.out.println(match);
    }
}