package com.hzau._35copycomplexlist;

/**
 * @description: 面试题35：复杂的链表复制
 * @author: Dafengsu
 * @date: 2019/8/9
 */
public class CopyComplexList {
    /**
     * 复制复杂链表：三歩法
     * 时间复杂度：O(n)
     * @param pHead 原始头节点
     * @return 复制链表的头节点
     */
    public RandomListNode clone(RandomListNode pHead) {
        //复制节点为原始节点的下一个节点
        cloneNodes(pHead);
        //链接复制节点的随机节点
        connectRandomNode(pHead);
        //拆分链表
        return reConnectNodes(pHead);
    }

    /**
     * 创建复制节点，并把复制节点和原始节点间隔链接
     * @param pHead 原始节点头节点
     */
    private void cloneNodes(RandomListNode pHead) {
        //创建辅助节点
        RandomListNode pNode = pHead;
        while (pNode != null) {
            //创建复制节点
            RandomListNode pCloneNode = new RandomListNode(pNode.label);
            //把复制节点的下一个节点设置为pNode的下一个节点
            pCloneNode.next = pNode.next;
            //把pNode的下一个节点设置为复制节点
            pNode.next = pCloneNode;
            //pNode遍历到下一个pNode
            pNode = pCloneNode.next;
        }
    }

    /**
     * 链接复制节点的随机节点
     * @param pHead 原始节点的头节点
     */
    private void connectRandomNode(RandomListNode pHead) {
        //创建原始节点的辅助节点
        RandomListNode pNode = pHead;
        //创建复制节点的辅助节点
        RandomListNode pCloneNode;
        while (pNode != null) {
            //复制节点是原始节点的下一个节点
            pCloneNode = pNode.next;
            if (pNode.random != null) {
                //复制节点的随机节点是原始节点随机节点的下一个节点
                pCloneNode.random = pNode.random.next;
            }
            //原始节点移动到下一个节点
            pNode = pCloneNode.next;
        }
    }

    /**
     * 把原始链表和复制链表分开
     * @param pHead
     * @return
     */
    private RandomListNode reConnectNodes(RandomListNode pHead) {
        //创建原始节点的辅助节点
        RandomListNode pNode = pHead;
        //创建复制节点的头节点
        RandomListNode pCloneHead = null;
        //创建复制节点的辅助节点
        RandomListNode pCloneNode = null;
        //如果头节点不为空
        if (pHead != null) {
            //复制节点的头节点等于原始头节点的下一个节点
            pCloneHead = pCloneNode = pNode.next;
            //原始节点的下一个节点等于复制节点的下一个节点
            pNode.next = pCloneNode.next;
            //原始节点移动到其下一个节点
            pNode = pNode.next;
        }
        while (pNode != null) {
            //复制节点的下一个节点等于原始节点的下一个节点
            pCloneNode.next = pNode.next;
            //复制节点移动到下一个节点
            pCloneNode = pCloneNode.next;
            //原始节点的下一个节点等于复制节点的下一个节点
            pNode.next = pCloneNode.next;
            //原始节点移动到下一个节点
            pNode = pNode.next;
        }
        return pCloneHead;
    }

}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "RandomListNode{" +
                "label=" + label +
                ", random=" + (random==null?null:random.label) +
                "} "+ next;
    }
}
