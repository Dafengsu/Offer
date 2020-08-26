package com.dfs._02singleton;

/**
 * @Description: 用枚举实现单例模式
 * @Author: Dafengsu
 * @Date: 2019/7/25 02:23
 */
public enum EnumSingleton {

    /**
     * 枚举
     */
    INSTANCE("name"),TEST("name");
    String name;
    EnumSingleton(String name) {

    }

    /**
     * 测试方法
     */
    public void test() {
        System.out.println("测试枚举单列模式");
    }


}
