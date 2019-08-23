package com.hzau._54kthnodeinbst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/21
 */
class KthNodeInBSTTest {
    /**
     * 创建实例
     */
    KthNodeInBST kthNodeInBST = new KthNodeInBST();

    @Test
    void kthNode() {
        test1();
    }

    void test(String testName, TreeNode pRoot, int k, TreeNode expected) {
        System.out.println(testName + ": begins");
        TreeNode res = kthNodeInBST.kthNode(pRoot, k);
        if (res == expected) {
            System.out.println(testName + " passed!");
        } else {
            System.out.println(testName + "  failed!");
        }
    }

    void test1() {
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode5= new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode11 = new TreeNode(11);
        treeNode8.left = treeNode6;
        treeNode8.right = treeNode10;
        treeNode6.left = treeNode5;
        treeNode6.right = treeNode7;
        treeNode10.left = treeNode9;
        treeNode10.right = treeNode11;
        int k = 5;
        TreeNode expected = treeNode9;
        test("test1", treeNode8, 8, null);

    }
}