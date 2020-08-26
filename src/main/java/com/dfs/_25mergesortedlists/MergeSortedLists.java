package com.dfs._25mergesortedlists;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/7
 */
public class MergeSortedLists {
    /**
     * 合并两个链表（单调不递减），返回头节点(循环的方法）
     * @param list1 链表1
     * @param list2 链表2
     * @return  返回头节点
     */
    public ListNode merge(ListNode list1,ListNode list2) {
        //如果有一个链表为空，直接返回另一个
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //创建头节点
        ListNode head;
        //给头节点赋值
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        //创建辅助节点
        ListNode temp = head;
        //循环遍历两个表，合并链表
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        //如果有一个链表已经遍历完毕，直接链接上另一个，都遍历完毕，就链接一个空值
        if (list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }
        return head;
    }

    public ListNode merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            head.next = merge2(list1.next, list2);
        } else {
            head = list2;
            head.next = merge2(list1, list2.next);
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
