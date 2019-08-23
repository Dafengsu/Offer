package com.hzau._09queuewithtwostacks;

import java.util.Stack;

/**
 * @description: 面试题9：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author: Dafengsu
 * @date: 2019/7/31
 */
public class QueueWithTwoStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 添加元素直接压入栈1
     * @param node 元素
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 抛出元素先从栈二开始
     * 如果栈二为空，就先从栈二取出元素到栈二中(栈1中先进后出（A,B,C))，
     * 抛出顺序既栈二入栈顺序为(C,B,A),栈二抛出顺序为(A,B,C)
     * @return 抛出元素
     */
    public int pop() {
        if(stack2.size()<=0){
            while(stack1.size()>0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
