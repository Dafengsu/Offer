package com.dfs._31stackpushpoporder;

import java.util.Stack;
/**
 * @description:    面试题31：栈的压入和弹出序列
 * @author: Dafengsu
 * @date: 2019/8/8
 */
public class StackPushPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        //排除空指针和空值
        if (pushA == null || popA == null || popA.length == 0 || popA.length != pushA.length) {
            return false;
        }
        //记录序列长度
        int length = popA.length;
        //记录入栈序列下标
        int pushIndex = 0;
        //记录出栈序列下标
        int popIndex = 0;
        //创建模拟栈
        Stack<Integer> stack = new Stack<>();
        //入栈序列未结束时，持续入栈
        while (pushIndex < length && popIndex < length) {
            //如果栈为空，直接先入栈一次（防止空指针）
            if (stack.isEmpty()) {
                stack.push(pushA[pushIndex++]);
            }
            //如果栈顶不等于出栈序列，就入栈，同时移动入栈数组下标
            while (pushIndex < length && stack.peek() != popA[popIndex]) {
                stack.push(pushA[pushIndex++]);
            }
            //如果栈不为空，且栈顶等于出栈序列
            while (popIndex < length && !stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return pushIndex == popIndex;
    }
}
