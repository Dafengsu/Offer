package com.hzau._07reConstructBinaryTree;

import java.util.Arrays;

/**
 * @description: 根据前序和中序遍历，重建二叉树
 * @author: Dafengsu
 * @date: 2019/7/30
 */
public class ConstructBinaryTree {
    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
       /* int[] ints = Arrays.copyOfRange(pre, 1, 3);
        System.out.println(Arrays.toString(ints));*/
        TreeNode treeNode = constructBinaryTree.reConstructBinaryTree2(pre, in);
        System.out.println(treeNode);

    }

    /**
     * 重建二叉树：直接复制数组
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //排除空指针
        if ((pre == null || pre.length == 0) && (in == null || in.length == 0)) {
            return null;
        }

        //根据前序遍历找到当前子树的根节点的值
        //根节点
        TreeNode root = new TreeNode(pre[0]);
        //根据中序遍历找到当前子树根节点的位置
        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == root.val) {
                index = i;
                break;
            }
        }
        //递归构建左子树，把返回结果设置为当前子树根节点的左子树
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index+1), Arrays.copyOfRange(in, 0, index));
        //递归构建右子树，把返回结果设置成当前子树根节点的右子树
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(in, index + 1, in.length));
        return root;
    }

    /**
     * 解耦，不复制数组
     * @param pre 前序遍历结果
     * @param in  中序遍历结果
     * @return
     */
    public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
        return ConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }


    /**
     * 构建二叉树
     *
     * @param pre      前序遍历结果
     * @param preStart 前序遍历起点
     * @param preEnd   前序遍历中点
     * @param in       中序遍历结果
     * @param inStart  中序遍历起点
     * @param inEnd    中序遍历终点
     * @return 当前子树根节点
     */
    public TreeNode ConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        //排除空节点
        if (preStart > preEnd && inStart > inEnd) {
            return null;
        }
        //根据前序遍历获取当前子树根节点的值
        //根节点
        TreeNode root = new TreeNode(pre[preStart]);
        //根据中序遍历获取根节点所在的位置
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val) {
                /**
                 * 当节点的下标为i时，左子树的长度为i-inStart
                 */
                //递归遍历左子树，把结果设为根节点的左子树
                root.left = ConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                //递归遍历右子树，把结果设为根节点的右子树
                root.right = ConstructBinaryTree(pre, preStart + i + 1 - inStart, preEnd, in, i + 1, inEnd);
            }
        }


        return root;

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
