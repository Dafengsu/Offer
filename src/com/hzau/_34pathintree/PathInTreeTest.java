package com.hzau._34pathintree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/8
 */
class PathInTreeTest {
    /**
     * 创建实例
     */
    PathInTree pathInTree = new PathInTree();
    @Test
    void findPath() {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(12);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        ArrayList<ArrayList<Integer>> res = pathInTree.findPath(treeNode1, 22);
        System.out.println(res);
    }
}