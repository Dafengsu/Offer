package com.dfs._03array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/25
 */
class FindDuplicationNoEditTest {
    FindDuplicationNoEdit findDuplicationNoEdit = new FindDuplicationNoEdit();
    @Test
    void duplication() {
         test1();
         test2();
         test3();
         test4();
         test5();
         test6();
         test7();
         test8();
         test9();
         test10();
    }

   /**
     * 多个重复的数字
     */
    void test1() {
        int[] numbers = { 2, 3, 5, 4, 3, 2, 6, 7 };
        int index = findDuplicationNoEdit.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }/**
     *  一个重复的数字
     */
    void test2() {
        int[] numbers = { 3, 2, 1, 4, 4, 5, 6, 7 };
        int index = findDuplicationNoEdit.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }/**
     * 重复的数字是数组中最小的数字
     */
    void test3() {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 1, 8 };
        int index = findDuplicationNoEdit.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }/**
     * 重复的数字是数组中最大的数字
     */
    void test4() {
        int[] numbers = { 1, 7, 3, 4, 5, 6, 8, 2, 8 };
        int index = findDuplicationNoEdit.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }/**
     * 数组中只有两个数字
     */
    void test5() {
        int[] numbers = { 1, 1 };
        int index = findDuplicationNoEdit.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }/**
     * 重复的数字位于数组当中
     */
    void test6() {
        int[] numbers = { 1, 2, 2, 6, 4, 5, 6 };
        int index = findDuplicationNoEdit.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }/**
     * 多个重复的数字
     */
    void test7() {
        int[] numbers = { 1, 2, 2, 6, 4, 5, 6 };
        int index = findDuplicationNoEdit.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }/**
     * 一个数字重复三次
     */
    void test8() {
        int[] numbers = { 1, 2, 2, 6, 4, 5, 2 };
        int index = findDuplicationNoEdit.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }/**
     * 没有重复的数字
     */
    void test9() {
        int[] numbers = { 1, 2, 6, 4, 5, 3 };
        int index = findDuplicationNoEdit.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }/**
     * 无效的输入
     */
    void test10() {
        int[] numbers = null;
        int index = findDuplicationNoEdit.duplication(numbers);
        System.out.println(Arrays.toString(numbers) + " 重复值是:" + index);
    }
}
