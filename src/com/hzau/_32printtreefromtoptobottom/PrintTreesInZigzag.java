package com.hzau._32printtreefromtoptobottom;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/8
 */
public class PrintTreesInZigzag {
    /**
     * 利用栈进行层次遍历
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        //创建记录结果的数组链表
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //排除空值
        if (pRoot == null) {
            return res;
        }
        //创建辅助队列
        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();

        //创建辅助数组链表
        ArrayList<Integer> subRes = new ArrayList<>();
        //把辅助数组链表加入到结果中
        res.add(subRes);
        //创建辅助节点
        TreeNode tempNode;
        //当前层次的奇偶性
        int cur = 0;
        //下移层次的奇数偶性
        int next = 1;
        //根节点入栈
        stacks[cur].push(pRoot);
        //队列不为空
        while (!stacks[cur].isEmpty()) {
            //抛出栈顶
            tempNode = stacks[cur].pop();
            //记录结果
            subRes.add(tempNode.val);
            //把左右子节点压入栈
            if (cur == 0) {
                if (tempNode.left != null) {
                    stacks[next].push(tempNode.left);
                }
                if (tempNode.right != null) {
                    stacks[next].push(tempNode.right);
                }
            }else {
                if (tempNode.right != null) {
                    stacks[next].push(tempNode.right);
                }
                if (tempNode.left != null) {
                    stacks[next].push(tempNode.left);
                }
            }


            //判断当前层的栈是否空
            if (stacks[cur].isEmpty() && !stacks[next].isEmpty()) {
                //创建一个新的链表数组
                subRes = new ArrayList<>();
                //把新链表数组加入到结果中
                res.add(subRes);
                cur = 1-cur;
                next = 1 - next;

            }

        }

        return res;
    }
}
