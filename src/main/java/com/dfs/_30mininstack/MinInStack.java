package com.dfs._30mininstack;
import java.util.Stack;

/**
 * @description: 面试题30：实现包含min函数的栈
 * min函数只要输出栈中的最小值(输出后值仍然在栈中)，所以只要peek就可以了
 * @author: Dafengsu
 * @date: 2019/8/8
 */
public class MinInStack {
    /**
     * 主栈
     */
    private Stack<Integer> data = new Stack<>();
    /**
     * 辅助栈
     */
    private Stack<Integer> minData = new Stack<>();

    /**
     * 压栈
     *
     * @param node 数值
     */
    public void push(int node) {
        //主栈直接入栈
        data.push(node);
        //辅栈入栈当前栈的最小值
        //如果辅栈为空，直接入栈
        if (minData.isEmpty()) {
            minData.push(node);
        } else {
            //如果入栈值小于辅助栈栈顶，入栈值入辅栈
            if (node < minData.peek()) {
                minData.push(node);
                //否则再次入一次辅助栈栈顶的值
            } else {
                minData.push(minData.peek());
            }
        }

    }

    /**
     * 出栈，主栈和辅助栈要同时出栈
     */
    public void pop() {
        data.pop();
        minData.pop();
    }

    /**
     * 查看栈顶
     * @return  栈顶值
     */
    public int top() {
        return data.peek();
    }

    /**
     * 查看栈中最小的值
     * @return  直接查看辅助栈的栈顶
     */
    public int min() {
        return minData.peek();
    }
}
