package com.dfs._14cuttingrope;

/**
 * @description: 面试题14：剪绳子
 * 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 * 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * 时得到最大的乘积18。
 * @author: Dafengsu
 * @date: 2019/8/1
 */
public class CuttingRope {
    /*=====================动态规划算法======================*/

    /**
     * 动态规划算法解决割绳子问题：
     * 思路是：从最简单的问题开始,既从最小值开始计算，然后把结果记录下来，
     * 给后面的计算用。每一个结果都是当前结果的最优解，然后后面的结果在前
     * 面的最优解结果上进行计算。
     * @param length 绳子长度
     * @return 返回最优解的值
     */
    public int maxProductAfterCutting(int length) {
        /**
         * 因为必须切一刀，所以前面几个，不用切就是最大值的
         * 要作为特例直接输出。
         */
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        /**
         * 创建数组记录最优解，前几个最优解特殊情况。
         */
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        //记录最大值
        int max = 0;
        //从小到大计算最优解
        for (int i = 4; i <= length; i++) {
            //初始化最大值
            max = 0;
            /**
             * 1.这里的主要思想是，第一刀切下去，切成两段，
             * 两段接下来的最优解已经在前面计算出来，所以直
             * 接用记录下来的最优解相乘，就是这一刀之
             * 后继续切的最优解。
             * 2.循环的时候不需要全部遍历，遍历前一半就
             * 行，后一半的结果和前一半的结果一样。
             */
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                //取最大值
                if (max < product) {
                    max = product;
                }
            }
            //记录最大值
            products[i] = max;
        }
        //取出最后一个位置的最大值
        max = products[length];
        return max;
    }

    /*===========================贪婪算法==========================*/

    /**
     * 贪婪算法解决切绳子的问题：
     * 和动态规划算法不同，贪婪算法的首选原则不是遍历，
     * 而是选择一种策略，每一步都获得这个策略之下的最优解。
     * 但是这种算法不一定是最优解，选择策略有一定难度。
     * @param length 绳子长度
     * @return  最优解的值
     */
    public int maxProductAfterCutting2(int length) {
        /**
         * 因为必须切一刀，所以前面几个，不用切就是最大值的
         * 要作为特例直接输出。
         */
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        //尽可能减去更多的3
        int timesOf3 = length / 3;
        //当长度为4时不能选择3*1，而应该是2*2
        if (length - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        //只有两种情况，需要选择2，一是5（2,3），二是4（2,2）
        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
