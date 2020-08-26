package com.dfs._32printtreefromtoptobottom;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @description:    面试题32（二）:分行从上到下打印二叉树
 * @author: Dafengsu
 * @date: 2019/8/8
 */
public class PrintTreesInLines {
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
        Queue<TreeNode> queue = new ArrayDeque<>();
        //创建辅助数组链表
        ArrayList<Integer> subRes = new ArrayList<>();
        //把辅助数组链表加入到结果中
        res.add(subRes);
        //创建辅助节点
        TreeNode tempNode;
        //记录当前层需要打印的次数
        int toBePrint = 1;
        //记录下一层需要打印的次数
        int nextLevel = 0;
        //根节点入栈
        queue.add(pRoot);
        //队列不为空
        while (!queue.isEmpty()) {
            //抛出队头
            tempNode = queue.remove();
            //记录结果
            subRes.add(tempNode.val);
            //如果左子节点不为空，左子节点入队列
            if (tempNode.left != null) {
                queue.add(tempNode.left);
                nextLevel++;
            }
            //如果右子节点不为空，右子节点入队列
            if (tempNode.right != null) {
                queue.add(tempNode.right);
                nextLevel++;
            }
            //打印值减1
            toBePrint--;
            //如果当前层打印值为0，且下一层打印值不为空
            if (toBePrint == 0 && nextLevel > 0) {
                //创建一个新的链表数组
                subRes = new ArrayList<>();
                //把新链表数组加入到结果中
                res.add(subRes);
                //更新到下一层的打印值
                toBePrint = nextLevel;
                //初始化下一层的打印值
                nextLevel = 0;
            }
        }

        return res;
    }

    /**
     * 递归的方法打印
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > print2(TreeNode pRoot) {
        //创建结果数组
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        //从第一层开始遍历
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        //如果根几点为空，直接返回
        if (root == null) {
            return;
        }
        //如果当前层数大于结果链表元素数，创建子链表，并加入到结果链表中
        if (depth > list.size()) {
            list.add(new ArrayList<Integer>());
        }
        //把当前节点加入到对对应的子链表中
        list.get(depth - 1).add(root.val);
        //递归遍历左子树
        depth(root.left, depth + 1, list);
        //递归遍历右子树
        depth(root.right, depth + 1, list);
    }

}
