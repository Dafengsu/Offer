package com.hzau._06PrintListInReversedOrder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/25
 */
public class PrintListInReversedOrder {
    public static void main(String[] args) {
        ListNode listNode = null;
        PrintListInReversedOrder printListInReversedOrder = new PrintListInReversedOrder();
       /* ArrayList<Integer> results = printListInReversedOrder.printReversed(listNode);
        System.out.println(results);*/

    }
    /**
     * 反转输出链表:利用栈
     *
     * @param listNode 根节点
     * @return
     */
    public ArrayList<Integer> printReversed(ListNode listNode) {
        //创建一个数组链表
        ArrayList<Integer> values = new ArrayList<>();
        //排除空节点
        if (listNode == null) {
            return values;
        }
        //建立双端队列作为一个栈使用
        Deque<ListNode> stack = new ArrayDeque<>();
        //添加根节点
        stack.push(listNode);
        //循环添加下一个节点到栈中，下一个节点为空
        while (listNode.next != null) {
            stack.push(listNode.next);
            listNode = listNode.next;
        }

        //循环输出节点到链表中
        while (stack.peek() != null) {
            values.add(stack.pop().val);
        }
        return values;
    }

    /**
     * 反转输出链表：利用递归
     *
     * @param listNode
     * @return
     */
    ArrayList<Integer> ref = new ArrayList<>();
    public ArrayList<Integer> printReversed2(ListNode listNode) {
        //排除非空链表，如果为空直接输出空链表
        if (listNode == null) {
            return ref;
        }
        //如果下个节点不为空，就进行递归
        if (listNode.next != null) {
            printReversed2(listNode.next);
        }
        //把当前节点输出到链表
        ref.add(listNode.val);
        return ref;
    }

}

/**
 * 节点
 */
class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}
