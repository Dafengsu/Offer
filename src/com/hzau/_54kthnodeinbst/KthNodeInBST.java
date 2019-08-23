package com.hzau._54kthnodeinbst;


/**
 * @description:    面试题54：二叉搜索树的第k个节点
 * @author: Dafengsu
 * @date: 2019/8/21
 */
public class KthNodeInBST {
    int k;
    public TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        this.k = k;
        return kthNodeCore(pRoot);
    }

    private TreeNode kthNodeCore(TreeNode pRoot) {
        TreeNode target = null;
        if (pRoot.left != null) {
            target = kthNodeCore(pRoot.left);
        }
        if (target == null) {
            if (k == 1) {
                target = pRoot;
            }
            k--;
        }
        if (target == null && pRoot.right != null) {
            target = kthNodeCore(pRoot.right);
        }
        return target;
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