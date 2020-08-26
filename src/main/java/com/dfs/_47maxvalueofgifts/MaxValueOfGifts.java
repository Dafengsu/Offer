package com.dfs._47maxvalueofgifts;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:    面试题47：礼物的最大值
 * @author: Dafengsu
 * @date: 2019/8/19
 */
public class MaxValueOfGifts {
    /**
     * 动态规划的方法求解
     * @param arrays
     * @return
     */
    public int getMaxValue(int[][] arrays) {
        if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
            return 0;
        }
        int[] res = new int[arrays[0].length];

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                res[j] = maxValue(res, i, j) + arrays[i][j];
            }
        }
        return res[arrays[0].length - 1];
    }

    private int maxValue(int[] arrays, int i, int j) {
        int maxi = i > 0 ? arrays[j] : 0;
        int maxj = j > 0 ? arrays[j - 1] : 0;
        return Math.max(maxi , maxj);
    }

    /**
     * 转换成有向图求解：时间复杂性太高，不可取，和递归一样
     * @param arrays
     * @return
     */
    public  int getMaxValue2(int[][] arrays){
        if(arrays==null||arrays.length==0||arrays[0].length==0) {
            return 0;
        }
        //最大行数
        int maxRowIndex = arrays.length - 1;
        //最大列数
        int maxColIndex = arrays[0].length-1;
        //队列
        Queue<Node> queue = new LinkedList<>();
        //把第一个点入队列
        queue.offer(new Node(0, 0, arrays[0][0]));
        //当前节点
        Node nodeCur = null;
        //循环直到行数和列数都达到最大
        while (!(queue.peek().row==maxRowIndex && queue.peek().col==maxColIndex)){
            //抛出当前节点
            nodeCur = queue.poll();
            //如果当前节点不是最大行
            if(nodeCur.row!=maxRowIndex) {
                queue.offer(new Node(nodeCur.row+1,nodeCur.col,nodeCur.sum+arrays[nodeCur.row+1][nodeCur.col]));
            }
            //如果当前节点不是最大列
            if(nodeCur.col!=maxColIndex) {
                queue.offer(new Node(nodeCur.row,nodeCur.col+1,nodeCur.sum+arrays[nodeCur.row][nodeCur.col+1]));
            }
        }
        int maxSum = 0,temp = 0;
        //遍历剩余节点
        while (!queue.isEmpty()){
            temp = queue.poll().sum;
            if(temp>maxSum) {
                maxSum = temp;
            }
        }
        return maxSum;
    }

}
class Node{
    int row;
    int col;
    int sum;
    public Node(int r,int c,int s){
        row = r;col = c;sum = s;
    }
}
