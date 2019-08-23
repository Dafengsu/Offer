package com.hzau._21reorderarray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/7
 */
class ReorderArrayTest {
    /**
     * 创建实例
     */
    ReorderArray reorderArray = new ReorderArray();

    @Test
    void reOrderArray() {
      /*  int[] array = {1, 2, 3, 4, 5, 6, 7};*/
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        long start = System.currentTimeMillis();
        reorderArray.reOrderArray4(array);
        long end = System.currentTimeMillis();
//        System.out.println(Arrays.toString(array));
        System.out.println("排序花时：" + (end - start));
    }
}