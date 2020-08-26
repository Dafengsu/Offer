package com.dfs._36convertbinarysearchtree;

import java.util.Stack;

/**
 * @description:    面试题36：二叉搜索树和双向链表
 * @author: Dafengsu
 * @date: 2019/8/9
 */
public class ConvertBinarySearchTree {
    /**
     * 二叉搜索树转双向链表
     * @param pRootOfTree   二叉搜索树根节点
     * @return  双向链表头节点
     */
    public TreeNode convert(TreeNode pRootOfTree) {
        //如果头节点为空，直接返回空值
        if (pRootOfTree == null) {
            return null;
        }
        //创建节点记录双向链表的头节点
        TreeNode pResRoot = null;
        //创建节点记录中序遍历的最后一个节点
        TreeNode pLast = null;
        //获取到双向链表的最后一个节点
        pLast = convert(pRootOfTree, pLast);
        //遍历到双向链表的头节点
        while (pLast != null) {
            pResRoot = pLast;
            pLast = pLast.left;
        }
        return pResRoot;
    }

    /**
     * 递归转化的核心代码
     * @param pNode 当前节点
     * @param pLast  上一个节点
     * @return  返回已遍历的当前节点
     */
    private TreeNode convert(TreeNode pNode, TreeNode pLast) {

        //递归左子树
        if (pNode.left != null) {
            pLast = convert(pNode.left, pLast);
        }
        //把当前节点的左子节点指向遍历的前一个节点
        pNode.left = pLast;
        //如果前一个节点不为空，把前一个节点的右节点指向当前节点
        if (pLast != null) {
            pLast.right = pNode;
        }
        //把当前节点记为上一个节点
        pLast = pNode;
        //递归右子树
        if (pNode.right != null) {
            pLast = convert(pNode.right, pLast);
        }

        return pLast;
    }

    /**
     * 非递归的方法:
     * 基本思路是建立一个栈，先一路左子树入栈到底（直到无左子节点），然后抛出栈顶，对栈顶节点进行调整
     * 并记录当前节点为上一个节点，然后遍历当前节点右子节点，再次循环，实质过程和递归无区别。
     * @param pRootOfTree
     * @return
     */
    public TreeNode convert2(TreeNode pRootOfTree) {
        //如果头节点为空，直接返回空值
        if(pRootOfTree==null) {
            return null;
        }
        //创建一个辅助栈
        Stack<TreeNode> stack = new Stack<>();
        //创建一个辅助节点记录当前节点
        TreeNode pNode = pRootOfTree;
        //创建一个辅助节点记录上一个节点
        TreeNode pLast = null;
        //查看节点是否是中序遍历的第一个节点
        boolean isFirst = true;
        //如果当前节点不为空或栈不为空，循环继续
        while(pNode!=null||!stack.isEmpty()){
            //如果当前节点不为空，深度遍历左子树
            while(pNode!=null){
                stack.push(pNode);
                pNode = pNode.left;
            }
            //抛出栈顶
            pNode = stack.pop();
            //看这个节点是否是头节点
            if(isFirst){
                //记录头节点
                pRootOfTree = pNode;// 将中序遍历序列中的第一个节点记为root
                //把当前节点记录为前一个节点
                pLast = pNode;
                //修改头节点标识
                isFirst = false;
            }else{
                //把当前节点设为上一个节点的右节点
                pLast.right = pNode;
                //把当前节点的左节点设为上一个节点
                pNode.left = pLast;
                //把当前节点记为右节点
                pLast = pNode;
            }
            //移动到当前节点的右节点
            pNode = pNode.right;
        }
        return pRootOfTree;
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
