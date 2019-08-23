package com.hzau._21reorderarray;

/**
 * @description:    面试题21：调整数组顺序是奇数位于数组前段偶数位于数组后段
 * @author: Dafengsu
 * @date: 2019/8/7
 */
public class ReorderArray {
    /**
     * 不稳定
     * @param array
     */
    public void reOrderArray(int[] array) {
        //如果数组为空，或者数组长度小于等于1,直接返回。
        if (array == null || array.length <= 1) {
            return;
        }
        //标记奇数数组最后一位
        int oddIndex = 0;
        //标记偶数数组最前一位
        int evenIndex = array.length - 1;
        //辅助数
        int temp;
        //两个指针没有相遇前
        while (oddIndex < evenIndex) {
            //如果是奇数，奇数数组指针后移，直到遇到偶数
            while (oddIndex < evenIndex && array[oddIndex] % 2 == 1) {
                oddIndex++;
            }
            //如果是偶数，偶数数组前移，直到遇到奇数
            while (oddIndex < evenIndex && array[evenIndex] % 2 == 0) {
                evenIndex--;
            }
            //交换两个数
            temp = array[oddIndex];
            array[oddIndex] = array[evenIndex];
            array[evenIndex] = temp;
        }
    }

    /**
     *
     * @param array
     */
    public void reOrderArray2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        //这个下标之前的数据全部处理过
        int Index = 0;
        //偶数数组中的
        int tempIndex;
        while(Index<array.length){
            //oddIndex循环前移，直到遇到一个偶数
            while (Index < array.length && !isEven(array[Index])) {
                Index++;
            }
            //偶数后第一个值
            tempIndex = Index+1;
            //找到第一个奇数
            while ( tempIndex < array.length && isEven(array[ tempIndex])) {
                 tempIndex++;
            }
            //把找到的奇数放在最后一个奇数的位置上
            if( tempIndex<array.length){
                //记录下这个奇数
                int tmp = array[ tempIndex];
                //把这个奇数前的几个偶数依次前移
                for (int j =  tempIndex; j >Index; j--) {
                    array[j] = array[j-1];
                }
                array[Index++] = tmp;
            }else{// 查找失敗
                break;
            }
        }

    }

    public void reOrderArray3(int[] array) {
        //记录已经排好的奇数的位置
        int index = 0;
        //辅助数
        int temp;
        for (int i = 0; i < array.length; i++) {
            //找到一个奇数
            if (!isEven(array[i])) {
                //记录下此奇数的下标
                int j = i;
                //记录当前奇数的值
                temp = array[j];
                //把这个奇数之前的偶数全部后移一位
                while (j > index) {
                    array[j] = array[j - 1];
                    j--;
                }
                //把这个奇数放在奇数数组的最后一位
                array[j] = temp;
                //奇数数加+1
                index++;
            }
        }
    }

    public void reOrderArray4(int[] arr) {
        //如果数组为空，或者数组的长度不超过1，直接返回
        if (arr == null || arr.length <= 1) {
            return;
        }
        //标记奇数数组的下一个位置
        int oddIndex = 0;
        //辅助数
        int temp;
        //循环遍历所有数组找奇数
        for (int i = 0; i < arr.length; i++) {
            //如果是奇数，把其放在奇数数组的位置上
            if (!isEven(arr[i])) {
                //记录当前奇数的值
                temp = arr[i];
                //把奇数前的偶数全部后移一位
                for (int j = i; j > oddIndex; j--) {
                    arr[j] = arr[j - 1];
                }
                //把找到的奇数放在奇数数组位置
                arr[oddIndex] = temp;
                oddIndex++;
            }
        }
    }
    boolean isEven(int n){
        if ((n&1) == 0) {
            return true;
        }
        return false;
    }
}
