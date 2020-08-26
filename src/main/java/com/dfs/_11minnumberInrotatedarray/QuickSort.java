package com.dfs._11minnumberInrotatedarray;

/**
 * @description: 快速排序
 * @author: Dafengsu
 * @date: 2019/7/31
 */
public class QuickSort {
    /**
     * 快速排序
     * @param arr 数组
     */
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     * @param arr 数组
     * @param start 起点下标
     * @param end 终点下标
     */
    public void quickSort(int[] arr, int start, int end) {
        //如果子数组的起点下标小于终点下标，就继续递归排序
        if (start < end) {
            //对当前子数组进行划分，获得标识值的下标
            int index = partition(arr, start, end);
            //对左子数组进行排序
            quickSort(arr, start, index - 1);
            //对右子数组进行排序
            quickSort(arr, index + 1, end);
        }

    }

    /**
     * 划分子程序
     * 功能：以数组最后一个值为标识符，把数组划分成两个数组
     * @param arr 数组
     * @param start 起点下标
     * @param end   终点下标
     * @return 最终标识值在数组中的下标
     */
    public int partition(int[] arr, int start, int end) {
        //取数组末尾的值作为标识值
        int x = arr[end];
        //初始化指标i，i表示小于标识值的子数组的最后一个值的下标，初始值是-1，或者是这个数组的前一个位置
        int i = start - 1;
        //辅助值
        int temp;
        //遍历（从第一个值到倒数第二个值）
        for (int j = start; j < end; j++) {
            //如果数值小于标识值，就进行交换
            if (arr[j] < x) {
                //小于标识数的子数组的最后一个下标前进一位
                i++;
                //把当前值放与小于标识数的子数组的后面(与当前这个位置的值进行交换)
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //遍历结束，把标识值，放在小于标识值的子数组最后(与当前这个位置的值进行交换）
        temp = arr[i + 1];
        arr[i + 1] = x;
        arr[end] = temp;
        //返回标识值所在位置
        return i + 1;
    }
}
