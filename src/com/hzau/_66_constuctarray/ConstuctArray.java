package com.hzau._66_constuctarray;

import java.util.Arrays;

/**
 * @description:    面试题66：构建乘积数组
 * @author: Dafengsu
 * @date: 2019/8/23
 */
public class ConstuctArray {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int length = A.length;
        int[] res = new int[length];
        res[0] = 1;
        int temp = 1;
        //计算下三角连乘
        for(int i = 1; i < length; i++){
            res[i] = res[i-1] * A[i-1];
        }
        //计算上三角
        for(int j = length-2; j >= 0; j--){
            temp *= A[j+1];
            res[j] *= temp;
        }
        return res;
    }
}
