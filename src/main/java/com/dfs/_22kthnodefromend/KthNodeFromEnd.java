package com.dfs._22kthnodefromend;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/7
 */
public class KthNodeFromEnd {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        //辅助节点
        ListNode tempNode1 = head;
        //结果节点
        ListNode resNode = head;
        //辅助计数值
        int count = 0;
        while (tempNode1.next != null) {
            tempNode1 = tempNode1.next;
            if (count >= (k - 1)) {
                resNode = resNode.next;
            }
            count++;
        }
        return count >= (k - 1) ? resNode : null;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
