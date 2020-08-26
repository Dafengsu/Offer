package com.dfs._13robotmove;

/**
 * @description: 面试题13：机器人的运动范围
 * 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 * 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * @author: Dafengsu
 * @date: 2019/8/1
 */
public class RobotMove {
    /**
     * 机器人的运动范围
     * @param threshold 限制值
     * @param rows      总行数
     * @param cols      总列数
     * @return          返回可以移动多少个格子
     */
    public int movingCount(int threshold, int rows, int cols) {
        //排除空指针
        if (threshold <= 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        //创建一维数组记录位置是否被访问过
        boolean[] visited = new boolean[rows * cols];
        for (boolean b : visited) {
            b = false;
        }
        //调用核心方法计算机器人可以到达多少个位置
        int count = moveCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    /**
     * 计算机器人移动的核心方法
     *
     * @param threshold 限制值
     * @param rows      总行数
     * @param cols      总列数
     * @param row       所在行
     * @param col       所在列
     * @param visited   记录当前位置是否访问过的数组
     * @return 返回可以移动多少格
     */
    private int moveCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        //初始化记录值
        int count = 0;
        //检查是否满足限制条件
        if (check(threshold, rows, cols, row, col, visited)) {
            //标记当前位置已访问
            visited[row * cols + col] = true;
            //上下左右尝试，返回可以访问的格子数
            count = 1 + moveCountCore(threshold, rows, cols, row - 1, col, visited)
                    + moveCountCore(threshold, rows, cols, row, col - 1, visited)
                    + moveCountCore(threshold, rows, cols, row + 1, col, visited)
                    + moveCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    /**
     * 检查当前位置是否满足限制条件
     *
     * @param threshold 限制值
     * @param rows      总行数
     * @param cols      总列数
     * @param row       当前行
     * @param col       当前列
     * @param visited   记录是否被访问过的数组
     * @return 满足条件返回true
     */
    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        //判断是否满足条件
        //1.坐标是否在总范围内
        //2,计算值是否小于限制值
        if (row >= 0 && row < rows && col >= 0 && col < cols && getDigitSum(row) + getDigitSum(col) <= threshold && !visited[row * cols + col]) {
            return true;
        }
        return false;
    }

    /**
     * 获取当前坐标（行或列）的对应计算值
     * @param number    坐标值
     * @return  返回对应的值
     */
    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

}
