package com.dfs._18deletenodeinlist;

/**
 * @description: 套用C++的Java版，可能不适合
 * @author: Dafengsu
 * @date: 2019/8/6
 */
public class DeleteDuplicatedNode {
    ListNode deleteDuplicatedNode(ListNode pHead) {
        //如果头节点为空，直接返回
        if (pHead == null) {
            return pHead;
        }
        //记录前一个节点
        ListNode pre = null;
        //记录当前节点
        ListNode temp = pHead;
        //如果当前节点不为空
        while (temp != null) {
            //记录当前节点的下一个节点
            ListNode next = temp.next;
            //标识符，是否有节点要删除
            boolean needDelete = false;
            //下个节点的值，等于当前节点的值，就是要进行删除
            if (next != null && next.val == temp.val) {
                needDelete = true;
            }
            //如果不用删除
            if (!needDelete) {
                //把当前节点记为上一个节点
                pre = temp;
                //当前节点后移
                temp = temp.next;
                //如果要删除
            } else {
                //记录要删除节点的值
                int value = temp.val;
                //记录当前节点
                ListNode pToBeDel = temp;
                //如果当前节点的值等于要删除的值，一直跳过
                while (pToBeDel != null && pToBeDel.val == value) {
                    next = pToBeDel.next;
                    pToBeDel = next;
                }
                //如果当前节点为头节点
                if (pre == null) {
                    pHead = next;
                    //如果当前节点不是头节点
                } else {
                    pre.next = next;
                }
                temp = next;
            }
        }
        return pHead;
    }

    /**
     * 直接遍历，遇到重复节点，逐个跳过
     * @param pHead
     * @return
     */
    ListNode deleteDuplicatedNode2(ListNode pHead) {
        //如果头节点为空或者只有一个节点，直接返回
        if (pHead == null||pHead.next==null) {
            return pHead;
        }
        //记录上一个节点
        ListNode pre = null;
        //记录当前节点
        ListNode temp = pHead;
        //记录出现重复节点的节点的值
        int cur;
        //当前节点不为空
        while (temp != null) {
            //当前节点的下一个节点不为空，且当前节点的值等于下一个节点
            if (temp.next != null && temp.val == temp.next.val) {
                //记录重复节点的值
                cur = temp.val;
                //跳过当前两个节点
                temp = temp.next.next;
                //跳过接下来后面所有值等于重复节点值的节点
                while (temp != null && temp.val == cur) {
                    temp = temp.next;
                }
                //如果当前是头节点
                if (pre == null) {
                    pHead = temp;
                    //如果当前值不是头节点
                } else {
                    pre.next = temp;
                }
            //如果当前节点不出现重复值,直接遍历下个节点
            } else {
                //记录头节点
                pre = temp;
                //遍历下个节点
                temp = temp.next;
            }
        }
        return pHead;
    }
}
