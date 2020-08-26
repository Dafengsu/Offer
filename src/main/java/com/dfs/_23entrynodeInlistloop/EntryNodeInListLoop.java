package com.dfs._23entrynodeInlistloop;

/**
 * @description:    面试题23：寻找环的入口
 * @author: Dafengsu
 * @date: 2019/8/7
 */
public class EntryNodeInListLoop {
    public ListNode entryNodeOfLoop(ListNode pHead) {
        //链表中是否存在循环
        ListNode meetingNode = meetingNode(pHead);
        //链表中不存在循环，直接返回空值
        if (meetingNode == null) {
            return null;
        }
        //得到环中的节点数
        int nodesInLoop = 1;
        //从环中一个点开始
        ListNode pNode1 = meetingNode;
        //遍历节点，直到再次遇到这个节点，统计环中的节点数
        while (pNode1.next != meetingNode) {
            pNode1 = pNode1.next;
            ++nodesInLoop;
        }
        //先移动pNode1，次数为环中的节点数
        pNode1 = pHead;
        for (int i = 0; i < nodesInLoop; i++) {
            pNode1 = pNode1.next;
        }
        //再移动pNode1和pNode2
        ListNode pNode2 = pHead;
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        //两个节点相遇，相遇点就是环的入口
        return pNode1;
    }

    /**
     * 看是否存在环，如果存在环，返回环中的一个节点
     *
     * @param pHead 头节点
     * @return 返回空值或者环中的节点
     */
    private ListNode meetingNode(ListNode pHead) {
        //如果头节点为空，直接返回空
        if (pHead == null) {
            return null;
        }
        //一个移动缓慢的节点（一次移动一个节点）
        ListNode pSlow = pHead.next;
        if (pSlow == null) {
            return null;
        }
        //一个移动迅速的节点（一次移动两个节点）
        ListNode pFast = pSlow.next;
        while (pFast != null && pSlow != null) {
            //两个节点相遇，返回节点，链表中存在环
            if (pFast == pSlow) {
                return pFast;
            }
            //节点移动
            pSlow = pSlow.next;
            pFast = pFast.next;
            //防止控制
            if (pFast != null) {
                pFast = pFast.next;
            }
        }
        return null;
    }

    /**
     * 简化一点的解题方法
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop2(ListNode pHead) {
        //如果头节点为空，或者只有一个节点，直接返回空值
        if (pHead == null || pHead.next == null) {
            return null;
        }
        //辅助节点1
        ListNode pSlow = pHead;
        //辅助节点2
        ListNode pFast = pHead;
        //遍历节点，节点不为空
        while (pFast != null && pFast.next != null) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            //找到相遇的节点
            if (pFast == pSlow) {
                //重置pFast节点
                pFast = pHead;
                //遍历节点，直到两个节点相遇，跳出节点
                while (pFast != pSlow) {
                    pFast = pFast.next;
                    pSlow = pSlow.next;
                }
                return pFast;
            }
        }
        return null;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
