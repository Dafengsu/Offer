package com.dfs._24reverselist;

/**
 * @description: 面试题24
 * @author: Dafengsu
 * @date: 2019/8/7
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //前一个节点的指针
        ListNode preNode = null;
        //当前节点的指针
        ListNode curNode = head;
        //下一个节点的指针
        ListNode nextNode = null;
        while (curNode != null) {
            //记录下一个节点
            nextNode = curNode.next;
            //把当前节点的下一个节点指向前一个节点
            curNode.next = preNode;
            //把单前节点记录为上一个节点
            preNode = curNode;
            //移动当前节点到下一个节点
            curNode = nextNode;
        }
        //单前节点为空才退出循环，所以要返回都头一个节点
        return preNode;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


