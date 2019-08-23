package com.hzau._32printtreefromtoptobottom;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/8
 */
class PrintTreesInZigzagTest {
    /**
     * 创建实例
     */
    PrintTreesInZigzag printTreesInZigzag = new PrintTreesInZigzag();
    @Test
    void print() {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(10);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(11);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        ArrayList<ArrayList<Integer>> res = printTreesInZigzag.print(treeNode1);
        System.out.println(res);
    }
}