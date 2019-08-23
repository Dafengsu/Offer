package com.hzau._57_02_ContinuousSquenceWithSum;

import java.util.ArrayList;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/21
 */
public class ContinuousSquenceWithSum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (sum < 3) {
            return res;
        }
        int start = 1;
        int end = 2;
        int middle = (sum + 1) / 2;
        int curSum = start + end;
        while (start < middle) {
            if (curSum == sum) {
                res.add(putIntoList(start, end));
            }
            while (curSum > sum && start < middle) {
                curSum -= start;
                start++;
                if (curSum == sum) {
                    res.add(putIntoList(start, end));
                }
            }
            end++;
            curSum += end;
        }
        return res;
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (sum < 3) {
            return res;
        }
        int start = 1;
        int end = 2;
        int middle = (sum + 1) / 2;
        int curSum;
        while (start < middle) {
            curSum = (start + end) * (end - start + 1) / 2;
            if (curSum == sum) {
                res.add(putIntoList(start, end));
                end++;
            } else if (curSum < sum) {
                end++;
            } else {
                start++;
            }

        }
        return res;
    }
    private ArrayList<Integer> putIntoList(int start, int end) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            res.add(i);
        }
        return res;
    }
}
