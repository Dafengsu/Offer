package com.dfs._08nextNodeInBinaryTrees;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/30
 */
class NextNodeInBinaryTreesTest {
    NextNodeInBinaryTrees trees = new NextNodeInBinaryTrees();

    @Test

    void getNext() {
        test1();
    }

    /**
     *    5
     *  3    6
     *1  2 4   7
     *       8   9
     *
     * @return
     */
    void test1() {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node8 = new TreeLinkNode(8);
        TreeLinkNode node9 = new TreeLinkNode(9);
        node5.left = node3;
        node3.next = node5;
        node5.right = node6;
        node6.next = node5;
        node3.left = node1;
        node1.next = node3;
        node3.right = node2;
        node2.next = node3;
        node6.left = node4;
        node4.next = node6;
        node6.right = node7;
        node7.next = node6;
        node7.left = node8;
        node8.next = node7;
        node7.right = node9;
        node9.next = node7;

        TreeLinkNode testNode = node1;
        TreeLinkNode results = trees.getNext(testNode);

        String results2;
        results2 = (results == null ? "null" : String.valueOf(results.value));
        System.out.println(testNode.value + "下一个接点是" + results2);
    }
}
