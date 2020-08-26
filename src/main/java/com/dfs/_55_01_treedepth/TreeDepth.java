package com.dfs._55_01_treedepth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:    面试题55：二叉搜索树的深度
 * @author: Dafengsu
 * @date: 2019/8/21
 */
public class TreeDepth {
    /**
     * 递归的方法
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 非递归的方法
     * @param root
     * @return
     */
    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        int count = 0;
        int nexCount = 1;
        TreeNode curNode;
        while (queue.size() != 0) {
            curNode = queue.poll();
            count++;
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
            if (count == nexCount) {
                nexCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
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
