package com.dfs._03array;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/24 15:25
 */
public class ArraySearch {
    public boolean find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {

            return false;
        }
        /**
         * 总行数
         */
        int column = array.length;
        /**
         * 总列数
         */
        int row = array[0].length;
        /**
         * 行坐标
         */
        int i = 0;
        /**
         * 列坐标
         */
        int j = row - 1;
        while (i < array.length && j >= 0) {
            if (array[i][j] == target) {
                return true;
                //如果当前的值大于目标值，则当前列都大于目标值，所以舍弃当前列，左移
            } else if (array[i][j] > target) {
                j--;
                //如果当前的值小于目标值，则当前行都小于目标值，所以舍弃当前行，下移
            } else {
                i++;
            }

        }
        return false;
    }

}
