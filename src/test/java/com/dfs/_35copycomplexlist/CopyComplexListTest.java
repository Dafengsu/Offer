package com.dfs._35copycomplexlist;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/9
 */
class CopyComplexListTest {
    /**
     * 创建实例
     */
    CopyComplexList copyComplexList = new CopyComplexList();
    @Test
    void testClone() {
        test1();
    }

    void test(String testName, RandomListNode pHead) {
        if (testName != null) {
            System.out.println(testName+" begins:");
        }
        System.out.println("the original list is: " + pHead);
        RandomListNode pCloneHead = copyComplexList.clone(pHead);
        System.out.println("the clone list is: " + pCloneHead);
    }

    void test1() {
        RandomListNode pNode1 = new RandomListNode(1);
        RandomListNode pNode2 = new RandomListNode(2);
        RandomListNode pNode3 = new RandomListNode(3);
        RandomListNode pNode4 = new RandomListNode(4);
        RandomListNode pNode5 = new RandomListNode(5);
        pNode1.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = pNode5;
        pNode1.random = pNode3;
        pNode2.random = pNode5;
        pNode4.random = pNode2;
        test("test1", pNode1);
    }
}
