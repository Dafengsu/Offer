package com.hzau._55_02_balancedbinarytree;

/**
 * @description:    面试题55_02:平衡二叉树
 * @author: Dafengsu
 * @date: 2019/8/21
 */
public class BalancedBinaryTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalanced_SolutionCore(root, new int[1]);
    }

    private boolean isBalanced_SolutionCore(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        boolean left = isBalanced_SolutionCore(root.left, depth);
        int leftDepth = depth[0];
        boolean right = isBalanced_SolutionCore(root.right, depth);
        int rightDepth = depth[0];
        depth[0] = Math.max(leftDepth+1, rightDepth+1);
        if (left && right && Math.abs(leftDepth - rightDepth) <= 1) {
            return true;
        }
        return false;
    }

    public boolean IsBalanced_Solution2(TreeNode root) {
        return isBalanced_SolutionCore2(root) >= 0;
    }

    private int isBalanced_SolutionCore2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalanced_SolutionCore2(root.left);
        int right = isBalanced_SolutionCore2(root.right);
        return (left >= 0 && right >= 0 && Math.abs(left - right) <= 1) ? 1 + Math.max(left, right) : -1;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
        this.val = val;

    }

}