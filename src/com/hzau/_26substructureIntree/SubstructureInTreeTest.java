package com.hzau._26substructureIntree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/7
 */
class SubstructureInTreeTest {
    /**
     * 创建实例
     */
    SubstructureInTree substructureInTree = new SubstructureInTree();
    @Test
    void hasSubtree() {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(9);
        TreeNode treeNode5 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        TreeNode treeNode6 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(2);
        treeNode6.left = treeNode7;
        treeNode6.right = treeNode8;
        boolean res = substructureInTree.hasSubtree(treeNode1, treeNode6);
        System.out.println(res);
    }
}