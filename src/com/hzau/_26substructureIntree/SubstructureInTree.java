package com.hzau._26substructureIntree;

/**
 * @description:    面试题26：判断树root2是不是树root1的子结构
 * @author: Dafengsu
 * @date: 2019/8/7
 */
public class SubstructureInTree {
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        //如果两个子树任意一个为空直接返回false
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean results = false;
        if (root1.val == root2.val) {
            results = doesTree1HasTree2(root1, root2);
        }
        if (!results) {
            results = hasSubtree(root1.left, root2)
                    || hasSubtree(root1.right, root2);
        }

        return results;
    }

    private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        //如果子树遍历完毕返回true
        if (root2 == null) {
            return true;
        }
        //如果父树遍历完毕返回false
        if (root1 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            return doesTree1HasTree2(root1.left, root2.left)
                    && doesTree1HasTree2(root1.right, root2.right);
            //值不相等返回false
        }else{
            return false;
        }
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