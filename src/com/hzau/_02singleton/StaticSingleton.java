package com.hzau._02singleton;

/**
 * @Description: 静态内部类方式实现单列模式
 * @Author: Dafengsu
 * @Date: 2019/7/25 01:58
 */
public class StaticSingleton {
    public static void main(String[] args) {

    }
    /**
     * 私有化构造方法
     */
    private StaticSingleton() {

    }

    /**
     * 一个私有的静态内部类，用于初始化一个静态final实例
     */
    private static class StaticSingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    /**
     * 获取实例
     */
    public static StaticSingleton getInstance() {
        return StaticSingletonHolder.instance;
    }
}




