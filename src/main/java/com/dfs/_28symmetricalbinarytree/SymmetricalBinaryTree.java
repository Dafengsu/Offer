package com.dfs._28symmetricalbinarytree;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/7
 */
public class SymmetricalBinaryTree {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode pLeft, TreeNode pRight) {
        if (pLeft == null && pRight == null) {
            return true;
        }
        if (pLeft == null || pRight == null) {
            return false;
        }
        if (pLeft.val != pRight.val) {
            return false;
        }

        return isSymmetrical(pLeft.left, pRight.right)
                && isSymmetrical(pLeft.right, pRight.left);
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
