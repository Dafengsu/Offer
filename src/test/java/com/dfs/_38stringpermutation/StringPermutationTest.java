package com.dfs._38stringpermutation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/10
 */
class StringPermutationTest {
    /**
     * 创建实例
     */
    StringPermutation stringPermutation = new StringPermutation();

    @Test
    void permutation() {
       /* String test = "1234";
        ArrayList<String> res = stringPermutation.permutation2(test);
        System.out.println(res);*/

        int[] numbers = { -2, -3, -4, -5,-6};
        ArrayList<ArrayList<Integer>> res = stringPermutation.sumOfArrays(numbers, -6);
        System.out.println(res);
    }

}
