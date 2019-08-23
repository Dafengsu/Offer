package com.hzau._09queuewithtwostacks;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description: 相关题目：用两个队列实现栈
 * @author: Dafengsu
 * @date: 2019/7/31
 */
public class StackWithTwoQueue {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    /**
     * 实现添加元素到栈
     * @param node 元素
     */
    public void push(int node) {
        //两个队列都为空时，默认加到队列1，否者加入到空队列
        if (queue2.size() == 0) {
            queue1.add(node);
        } else {
            queue2.add(node);
        }

    }

    /**
     * 实现栈抛出元素
     * 队列1的入队顺序是（A,B,C)
     * @return 返回元素
     */
    public int pop() {
        //1.判断哪一个是非空队列
        //2.从非空队列中取出除最后一个元素以外的所有元素放入到空队列，删除非空队列中的最后一个元素
        //队列1为非空队列
        if (queue1.size() != 0) {
            //从非空队列中取出除最后一个元素以外的所有元素放入到空队列
            while (queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            //删除非空队列中的最后一个元素
            return queue1.remove();
        } else {
            while (queue2.size() > 1) {
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        }
    }
}
