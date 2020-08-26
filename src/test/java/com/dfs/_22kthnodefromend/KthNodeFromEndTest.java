package com.dfs._22kthnodefromend;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/7
 */
class KthNodeFromEndTest {
    /**
     * 创建实例
     */
    KthNodeFromEnd kthNodeFromEnd = new KthNodeFromEnd();
    @Test
    void findKthToTail() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode res = kthNodeFromEnd.findKthToTail(node1, 6);
       /* System.out.println(res.val);*/
    }
}
