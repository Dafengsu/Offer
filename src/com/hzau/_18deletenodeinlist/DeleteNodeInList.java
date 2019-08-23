package com.hzau._18deletenodeinlist;

/**
 * @description:    面试题18：删除目标节点
 * @author: Dafengsu
 * @date: 2019/8/6
 */
public class DeleteNodeInList {
    /**
     * 删除目标节点
     * @param head  头节点
     * @param node  目标节点
     */
    void deleteNode(ListNode head, ListNode node) {
        //如果头节点或者目标节点为空，直接返回
        if (head == null || node == null) {
            return;
        }
        //要删除的节点不是尾节点
        if (node.next != null) {
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
            //要删除节点只有一个节点，是头节点
        } else if (head == node) {
            head = null;
            //链表中有多个节点，删除尾节点
        } else {
            ListNode temp = head;
            while (temp.next != node) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }
}

/**
 * 节点
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + val +"}  "+ (next!=null? next :"");
    }

}
