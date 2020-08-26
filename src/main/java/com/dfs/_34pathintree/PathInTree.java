package com.dfs._34pathintree;

import java.util.ArrayList;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/8
 */
public class PathInTree {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        //创建结果链表
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //如果节点为空，直接返回空链表
        if (root == null) {
            return res;
        }
        //递归求解
        findPath(root, target, res, new ArrayList<Integer>());
        return res;
    }

    /**
     * 递归的方法
     * @param root  节点
     * @param target 目标值
     * @param res    总结果
     * @param subRes 子链表
     */
    private void findPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subRes) {
        //把当前节点的值加入到子链表
        subRes.add(root.val);
        if (root.val < target) {
            target -= root.val;
            if (root.left != null) {
                findPath(root.left, target, res, subRes);
            }
            //如果右子节点不为空，递归右子节点
            if (root.right != null) {
                findPath(root.right, target, res, subRes);
            }

            //如果节点的值和目标值相等
        } else if (root.left == null && root.right == null && root.val == target) {
            //在结果
            res.add(new ArrayList<Integer>(subRes));
        }
        subRes.remove(subRes.size() - 1);
    }

}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
