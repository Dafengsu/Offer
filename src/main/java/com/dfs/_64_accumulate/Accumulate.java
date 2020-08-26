package com.dfs._64_accumulate;

/**
 * @description:    面试64：求和，不用加减乘除
 * @author: Dafengsu
 * @date: 2019/8/22
 */
public class Accumulate {
    public int sum(int number) {
        int sum = number;
        boolean  ans = (number > 0) && ((sum += sum(number - 1)) > 0);
        return sum;
    }


}

