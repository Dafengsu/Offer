package com.dfs._57_01_TwoNumbersWithSum;

import java.util.ArrayList;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/21
 */
public class TwoNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0) {
            return res;
        }
        int left = 0;
        int right = array.length - 1;
        while (array[right] > sum) {
            right--;
        }
        int curSum;
        while (left < right) {
            curSum = array[left] + array[right];
            if (curSum == sum) {
                res.add(array[left]);
                res.add(array[right]);
                return res;
            } else if (curSum < sum) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
