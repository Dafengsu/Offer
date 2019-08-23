package com.hzau._62_lastnumberIncircle;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:    面试题62：圆圈中最后剩下的数字
 * @author: Dafengsu
 * @date: 2019/8/22
 */
public class LastNumberInCircle {
    public static void main(String[] args) {
        System.out.println("测试");
    }

    /**
     * 数学方法求解
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 0 || m < 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public int LastRemaining_Solution2(int n, int m) {
        if (n < 0 || m < 1) {
            return -1;
        }
        int index = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
