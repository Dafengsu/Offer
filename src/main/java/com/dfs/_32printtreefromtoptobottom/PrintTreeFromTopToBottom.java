package com.dfs._32printtreefromtoptobottom;

import java.util.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/8
 */
public class PrintTreeFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        //记录结果的数组链表
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //辅助链表
        Queue<TreeNode> queue = new ArrayDeque<>();
        //辅助节点
        TreeNode tempTreeNode;
        //把根节点压入栈中
        queue.add(root);
        //栈不为空时
        while (!queue.isEmpty()) {
            //抛出栈顶节点
            tempTreeNode = queue.remove();
            //记录当前节点的值
            res.add(tempTreeNode.val);
            //压入当前节点的左子节点
            if (tempTreeNode.left != null) {
                queue.add(tempTreeNode.left);
            }
            //压入当前节点的右子节点
            if (tempTreeNode.right != null) {
                queue.add(tempTreeNode.right);
            }
        }
        return res;
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
