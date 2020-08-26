package com.dfs._03array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/25
 */
class FindDuplicationTest {
    FindDuplication findDuplication = new FindDuplication();

    // 重复的数字是数组中最小的数字
    @Test
    void duplication() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    /**
     * 重复值是最小的值
     */
    void test1() {
        int[] numbers = {2, 1, 3, 1, 4};
        int index = findDuplication.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }

    /**
     *  重复的数字是数组中最大的数字
     */
    void test2() {
        int[] numbers = { 2, 4, 3, 1, 4 };
        int index = findDuplication.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }

    /**
     *   数组中存在多个重复的数字
     */
    void test3() {
        int[] numbers = { 2, 4, 2, 1, 4 };;
        int index = findDuplication.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }

    /**
     *    没有重复的数字
     */
    void test4() {
        int[] numbers = { 2, 1, 3, 0, 4 };;
        int index = findDuplication.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }

    /**
     *    没有重复的数字
     */
    void test5() {
        int[] numbers = { 2, 1, 3, 5, 4 };;
        int index = findDuplication.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }
    /**
     *    无效输入
     */
    void test6() {
        int[] numbers ={ -1 };;
        int index = findDuplication.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }
}
