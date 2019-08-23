package com.hzau._68_commonparentIntree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/23
 */
class CommonParentInTreeTest {
    /**
     * 创建实例
     */
    CommonParentInTree commonParentInTree = new CommonParentInTree();
    @Test

    void getLastParent() {
        test1();
        test2();
        test3();
    }

    void test(String testName, TreeNode pRoot, TreeNode first, TreeNode second, TreeNode expected) {
        System.out.println(testName + ": begins:");
        TreeNode res = commonParentInTree.getLastParent(pRoot, first, second);
        if (res == expected) {
            System.out.println(testName + " passed!");
        } else {
            System.out.println(testName + " failed");
        }
    }

    void test1()
    {
        TreeNode pNode1 = new TreeNode(1);
        TreeNode pNode2 = new TreeNode(2);
        TreeNode pNode3 = new TreeNode(3);
        TreeNode pNode4 = new TreeNode(4);
        TreeNode pNode5 = new TreeNode(5);
        TreeNode pNode6 = new TreeNode(6);
        TreeNode pNode7 = new TreeNode(7);
        TreeNode pNode8 = new TreeNode(8);
        TreeNode pNode9 = new TreeNode(9);
        TreeNode pNode10 = new TreeNode(10);

        pNode1.putChild(pNode2, pNode3);
        pNode2.putChild(pNode4, pNode5);
        pNode4.putChild(pNode6, pNode7);
        pNode5.putChild(pNode8, pNode9, pNode10);


        test("test1", pNode1, pNode6, pNode8, pNode2);
    }

    void test2()
    {
        TreeNode pNode1 = new TreeNode(1);
        TreeNode pNode2 = new TreeNode(2);
        TreeNode pNode3 = new TreeNode(3);
        TreeNode pNode4 = new TreeNode(4);
        TreeNode pNode5 = new TreeNode(5);

        pNode1.putChild(pNode2);
        pNode2.putChild(pNode3);
        pNode3.putChild(pNode4);
        pNode4.putChild(pNode5);
        test("test2", pNode1, pNode5, pNode4, pNode3);
    }



    void test3()
    {
        TreeNode pNode1 = new TreeNode(1);
        TreeNode pNode2 = new TreeNode(2);
        TreeNode pNode3 = new TreeNode(3);
        TreeNode pNode4 = new TreeNode(4);
        TreeNode pNode5 = new TreeNode(5);

        pNode1.putChild(pNode2);
        pNode2.putChild(pNode3);
        pNode3.putChild(pNode4);
        pNode4.putChild(pNode5);
        TreeNode pNode6 = new TreeNode(6);

        test("test3", pNode1, pNode5, pNode6, null);
    }
}