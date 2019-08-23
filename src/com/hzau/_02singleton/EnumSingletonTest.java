package com.hzau._02singleton;

import org.junit.jupiter.api.Test;

/**
 * @Description:
 * @Author: Dafengsu
 * @Date: 2019/7/25 02:29
 */
class EnumSingletonTest {

    @Test
    void test1() {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        instance.name = "su";
        instance.test();
    }
}