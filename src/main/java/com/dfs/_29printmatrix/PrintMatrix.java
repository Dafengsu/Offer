package com.dfs._29printmatrix;

import java.util.ArrayList;

/**
 * @description:    面试题29：顺时针打印矩阵
 * @author: Dafengsu
 * @date: 2019/8/7
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        //如果矩阵为空，矩阵内容为空，直接返回null
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        //矩阵列数
        int rows = matrix.length;
        //矩阵行数
        int columns = matrix[0].length;
        //循环打印的起始点：（0,0），（1,1），（2，2）等等
        int start = 0;
        //创建链表接收数据
        ArrayList<Integer> res = new ArrayList<>();
        //只有在列数和函数都满足要求的情况下，才可以继续循环，打印起始点的
        //横纵坐标都不能超过数组横纵长度的一半
        while (columns > start * 2 && rows > start * 2) {
            //转圈打印
            printMatrixInCircle(matrix, columns, rows, start, res);
            //起始点向右下移动
            start++;
        }
        return res;
    }

    /**
     * 旋转输出数据
     * @param matrix    数组
     * @param columns   数组列数
     * @param rows      数组行数
     * @param start     打印起始点
     * @param res       结果
     */
    private void printMatrixInCircle(int[][] matrix, int columns, int rows, int start, ArrayList<Integer> res) {
        //打印的横坐标终点
        int endX = columns - 1 - start;
        //打印的纵坐标终点
        int endY = rows - 1 - start;
        //从左到右输出
        for (int i = start; i <= endX; i++) {
            res.add(matrix[start][i]);
        }
        //从上到下输出（继续向下打印的条件是，起始点的纵坐标要大于终点纵坐标，既这个圈至少有两行）
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                res.add(matrix[i][endX]);
            }
        }
        //从左到右输出（继续向右打印的条件是，起始点的横坐标要小于终点横坐标，同时满足
        //起始点的纵坐标要小于终点的纵坐标，既当前圈至少有两行两列）
        if (start < endX & start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                res.add(matrix[endY][i]);
            }
        }
        //从下到上输出（继续大于的条件是，起始点的横坐标要小于终点横左标，同时满足
        //起点纵坐标要小于终点纵坐标-1，既当前圈至少要两行三列）
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                res.add(matrix[i][start]);
            }
        }
    }
}
