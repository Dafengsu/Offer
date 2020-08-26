package com.dfs._08nextNodeInBinaryTrees;

/**
 * @description:
 * 面试题8：二叉树的下一个结点
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 * @author: Dafengsu
 * @date: 2019/7/30
 */
public class NextNodeInBinaryTrees {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        //排除空节点
        if (pNode == null) {
            return null;
        }
        TreeLinkNode next = null;
        //如果右子树不为空,
        if (pNode.right != null) {
            //右节点
//            BinaryTreeNode right = pNode.right;
            next = pNode.right;
            //如果右节点的左子树不为空，持续遍历其左子树的左节点，找到右子树的最右节点
           /* while (right.left != null) {
                right = right.left;
            }
            next = right;*/
            while (next.left != null) {
                next = next.left;
            }
            //如果父节点不为空(父节点为空，就直接返回空的next了）
        } else if (pNode.next != null) {
          /*  //父节点
            BinaryTreeNode parent = pNode.parent;
            //当前节点
            BinaryTreeNode current = pNode;
            //如果当前节点的父节点不为空，且当前节点是父节点的右子节点，就一直回溯
            while (parent != null && parent.right == current) {
                current = parent;
                parent = current.parent;
            }
            //如果当前节点的父节点为空，或者当前节点是其父节点的左子节点，下个节点就是其父几点
            next = parent;*/
            //把当前节点设为next
            next = pNode;
            //如果当前节点的父节点不为空，且单前节点是父节点的右子节点，回溯父节点
            while (next.next != null && next.next.right == next) {
                next = next.next;
            }
            //当前节点的父节点为空或当前节点是父节点的左子节点
            next = next.next;


        }
        return next;
    }

}

class TreeLinkNode {
    int value;
    TreeLinkNode next;
    TreeLinkNode left;
    TreeLinkNode right;

    public TreeLinkNode(int value) {
        this.value = value;
    }

}
