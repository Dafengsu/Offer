package com.hzau._33squenceofbst;

/**
 * @description:    面试题33：二叉搜索树的后序遍历搜索序列
 * @author: Dafengsu
 * @date: 2019/8/8
 */
public class SquenceOfBST {
    /**
     * 递归的方法实现
     * @param sequence
     * @return
     */
    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return verifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean verifySquenceOfBST(int[] sequence, int start, int end) {
        //起点和终点相遇，直接返回true
        if (start >= end) {
            return true;
        }
        //取根节点
        int root = sequence[end];
        //表示位
        int index = 0;
        //取到第一个大于根节点的下标
        while (sequence[index] < root) {
            index++;
        }
        //遍历看后面的节点是不是都大于根节点
        for (int j = index; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        //递归查询左右子树
        return verifySquenceOfBST(sequence, start, index - 1)
                && verifySquenceOfBST(sequence, index, end - 1);
    }

    /**
     * 非递归，尾节点前面的值，存在在前面一段大于其值，后面一段小于其值的情况
     * @param sequence
     * @return
     */
    public boolean verifySquenceOfBST2(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        int end = sequence.length-1;
        int index = 0;
        while (end != 0) {
            while (sequence[index] < sequence[end]) {
                index++;
            }
            while (sequence[index] > sequence[end]) {
                index++;
            }
            if (index < end) {
                return false;
            }
            index = 0;
            end--;
        }
        return true;
    }

}
