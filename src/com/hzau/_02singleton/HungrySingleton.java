package com.hzau._02singleton;

/**
 * @Description:
 * @Author: Dafengsu
 * @Date: 2019/7/25 02:18
 */
public class HungrySingleton {
    /**
     * 直接初始化一个静态实例
     */
    private static HungrySingleton instance = new HungrySingleton();

    /**
     * 私有化构造器
     */
    private HungrySingleton() {

    }

    /**
     * 获取实例
     */
    public HungrySingleton getInstance() {
        return instance;
    }


}
