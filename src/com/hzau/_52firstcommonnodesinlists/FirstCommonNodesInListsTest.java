package com.hzau._52firstcommonnodesinlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/20
 */
class FirstCommonNodesInListsTest {
    /**
     * 创建实例
     */
    FirstCommonNodesInLists firstCommonNodesInLists = new FirstCommonNodesInLists();

    @Test
    void findFirstCommonNode() {
        test1();
    }

    void test(String testName, ListNode pHead1, ListNode pHead2, ListNode expected) {
        System.out.println(testName + ": begins");
        ListNode res = firstCommonNodesInLists.FindFirstCommonNode3(pHead1, pHead2);
        if (res == expected) {
            System.out.println(testName + " passed!");
        } else {
            System.out.println(testName + "  failed!");
        }
    }

    void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node7;
        node7.next = node8;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        test("test1", node1, node4, node7);
    }
}