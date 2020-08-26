package com.dfs._12stringpathInmatrix;

/**
 * @description: 面试题12：矩阵中的路径
 *  题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
 *  字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
 *  上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
 *  该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
 *  母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
 *  字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * @author: Dafengsu
 * @date: 2019/8/1
 */
public class StringPathInMatrix {
    /**
     * 矩阵中的路径
     * @param matrix 矩阵
     * @param string 字符串
     * @return 返回是否有路径
     */
    public boolean hasPath(char[][] matrix, String string) {
        //排除空指针
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || string == null) {
            return false;
        }
        //建立矩阵记录点是否被访问过
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        //路径标记
        int pathLength = 0;
        //创建地图类
        PathMap pathMap = new PathMap(matrix.length,matrix[0].length);
        //循环所有的点找到和第一个点符合的点开始循环
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[0].length; col++) {
                pathMap = hasPathCore(matrix, row, col, string, pathLength, visited,pathMap);
                if (pathMap.hasPath) {
                    int[][] map = pathMap.map;
                    int count = 0;
                    for (int i = 0; i < map.length; i++) {
                        for (int j = 0; j < map[i].length; j++) {
                            if (map[i][j] == 1) {
                                count++;
                                System.out.println("第" + count + "歩:" + "[" +i+","+j+"]");
                            }
                        }

                    }
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 矩阵路径的核心代码
     *
     * @param matrix     矩阵
     * @param row        矩阵中的行坐标
     * @param col        矩阵中的列坐标
     * @param str        字符串
     * @param pathLength 字符串下标
     * @param visited    记录矩阵中的位置是否被访问过
     * @return 返回是否寻找到位置
     */
    private PathMap hasPathCore(char[][] matrix, int row, int col, String str, int pathLength, boolean[][] visited, PathMap pathMap) {
        //如果路径走完了，直接返回true
        if (pathLength == str.length()) {
            pathMap.hasPath = true;
            return pathMap;
        }

      /*  //标记此次选择是否能够走通
        boolean hasPath = pathMap.hasPath;*/
        //尝试左上右下都走一下，能走通继续递归，不能就回溯
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] == str.charAt(pathLength) && !visited[row][col]) {
            pathLength++;
            visited[row][col] = true;
            pathMap.map[row][col] = 1;
            if (hasPathCore(matrix, row, col - 1, str, pathLength, visited,pathMap).hasPath
                    || hasPathCore(matrix, row - 1, col, str, pathLength, visited,pathMap).hasPath
                    || hasPathCore(matrix, row + 1, col, str, pathLength, visited,pathMap).hasPath
                    || hasPathCore(matrix, row, col + 1, str, pathLength, visited,pathMap).hasPath) {
                pathMap.hasPath = true;
            } else {
                pathLength--;
                visited[row][col] = false;
                pathMap.map[row][col] = 0;
            }
        }
        return pathMap;
    }

    /**
     * 创建一个地图类记录地图和属性
     */
    private class PathMap {
        int[][] map;
        boolean hasPath;

        public  PathMap(int row, int col) {
            map = new int[row][col];
            for (int[] ints : map) {
                for (int anInt : ints) {
                    anInt = 0;
                }

            }

        }
    }
}
