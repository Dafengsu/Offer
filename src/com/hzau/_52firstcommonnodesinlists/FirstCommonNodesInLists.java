package com.hzau._52firstcommonnodesinlists;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @description:    面试题52：第一个公共节点
 * @author: Dafengsu
 * @date: 2019/8/20
 */
public class FirstCommonNodesInLists {
    /**
     * 用set的方法解决问题
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode temp = pHead1;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = pHead2;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 用栈的方法解
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode temp = pHead1;
        while (temp != null) {
            stack1.push(temp);
            temp = temp.next;
        }
        temp = pHead2;
        while (temp != null) {
            stack2.push(temp);
            temp = temp.next;
        }
        ListNode curNode1 = null;
        ListNode curNode2;
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            curNode1 = stack1.pop();
            curNode2 = stack2.pop();

        }
        return curNode1;
    }

    /**
     * 不添加辅助节点的解法
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = getListLength(pHead1);
        int length2 = getListLength(pHead2);
        ListNode curNode1 = pHead1;
        ListNode curNode2 = pHead2;
        int gap;
        if (length1 <= length2) {
            gap = length2 - length1;
            while (gap != 0) {
                curNode2 = curNode2.next;
                gap--;
            }
        } else {
            gap = length1 - length2;
            while (gap != 0) {
                curNode1 = curNode1.next;
                gap--;
            }
        }
        while (curNode1 != null && curNode2 != null && curNode1 != curNode2) {
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }
        return curNode1;
    }

    /**
     * 获得链表长度
     * @param list
     * @return
     */
    private int getListLength(ListNode list) {
        int count = 0;
        ListNode temp = list;
        while (temp != null) {
            temp = temp.next;
            ++count;
        }
        return count;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}