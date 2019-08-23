package com.hzau._27mirrorofbinarytree;

import java.util.ArrayDeque;
import java.util.Deque;



/**
 * @description:    面试题27：树的镜像
 * @author: Dafengsu
 * @date: 2019/8/7
 */
public class MirrorOfBinaryTree {
    /**
     * 递归的方法求解
     * @param root  根节点
     */
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        exchange(root);
        mirror(root.left);
        mirror(root.right);
    }

    /**
     * 非递归的方法
     * @param root 根节点
     */
    public void mirror2(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        //辅助节点1
        TreeNode node;
        while (!stack.isEmpty()) {
            node = stack.remove();
            if (node.left != null || node.right != null) {
                exchange(node);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
    }
    private void exchange(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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