package com.dfs._18deletenodeinlist;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/6
 */
class DeleteDuplicatedNodeTest {
    /**
     * 创建实例
     */
    DeleteDuplicatedNode deleteDuplicatedNode = new DeleteDuplicatedNode();

    @Test
    void deleteDuplicatedNode() {
        test1();
    }

    void test1() {
        System.out.println("删除中间节点");
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(1);
        ListNode listNode7 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode head = listNode1;
        deleteDuplicatedNode.deleteDuplicatedNode(head);
        System.out.println(head);
    }
}
