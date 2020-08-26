package com.dfs._02singleton;

/**
 * @Description: 单例模式，懒汉
 * @Author: Dafengsu
 * @Date: 2019/7/25 00:48
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    /**
     *私有化构造器
     */
    private LazySingleton() {

    }

    /**
     * 提供获取实例的方法,适合单线程,多线程不安全（不推荐）
     */
    public static LazySingleton getInstanceA() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 提供获取实例的方法，适合多线程，效率低（不推荐）
     */
    public static synchronized LazySingleton getInstanceB() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 适合多线程，效率高，只有在需要创建实例的时候才锁，推荐
     * @return 返回实例
     */
    public static LazySingleton getInstanceC() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }


}
