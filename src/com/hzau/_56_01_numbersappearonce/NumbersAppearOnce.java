package com.hzau._56_01_numbersappearonce;

import java.util.ArrayList;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/21
 */
public class NumbersAppearOnce {
    public ArrayList<Integer> findNumbersAppearOnce(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int curRes = 0;
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int value : array) {
            curRes ^= value;
        }
        int index = findFirstIs1(curRes);
        for (int value : array) {
            if (isBit1(value, index)) {
                array1.add(value);
            } else {
                array2.add(value);
            }
        }
        curRes = 0;
        for (Integer value : array1) {
            curRes ^= value;
        }
        res.add(curRes);
        curRes = 0;
        for (Integer value : array2) {
            curRes ^= value;
        }
        res.add(curRes);
        return res;
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int curRes = 0;
        for (int value : array) {
            curRes ^= value;
        }
        int index = findFirstIs1(curRes);
        for (int value : array) {
            if (isBit1(value, index)) {
                num1[0] ^= value;
            } else {
                num2[0] ^= value;
            }
        }
    }
    private int findFirstIs1(int num) {
        int index = 0;
        while ((num & 1) == 0) {
            num >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int num, int index) {
        num >>= index;
        return (num & 1) == 0;
    }
}

