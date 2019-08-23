package com.hzau._18deletenodeinlist;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/6
 */
class DeleteNodeInListTest {
    /**
     * 创建实例
     */
    DeleteNodeInList deleteNodeInList = new DeleteNodeInList();

    @Test
    void deleteNode() {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    void test(ListNode head, ListNode node) {
        System.out.println("The original list is: ");
        System.out.println(head);
        System.out.println("The node to be deleted is: ");
        System.out.println(node);
        deleteNodeInList.deleteNode(head, node);
        System.out.println("The result list is: ");
        System.out.println(head);
    }

    /**
     * 删除中间节点
     */
    void test1() {
        System.out.println("删除中间节点");
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        test(listNode1, listNode1);
    }

    /**
     * 删除头节点
     */
    void test2() {
        System.out.println("删除头节点");
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        test(listNode1, listNode1);
    }
    /**
     * 删除尾节点
     */
    void test3() {
        System.out.println("删除尾节点");
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        test(listNode1, listNode5);
    }

    /**
     * 只有一个节点，删除头节点
     */
    void test4() {
        System.out.println("只有一个节点，删除头节点");
        ListNode listNode1 = new ListNode(1);
        test(listNode1, listNode1);
    }

    /**
     * 链表为空
     */
    void test5() {
        System.out.println("链表为空");
        test(null, null);
    }
}