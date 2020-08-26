package com.dfs._44digitsInsequence;

/**
 * @description:    面试题44：数字序列中某一位的数字
 * @author: Dafengsu
 * @date: 2019/8/18
 */
public class DigitsInSequence {
    /**
     *
     * @param index
     * @return
     */
    public int digitAtIndex(int index) {
        //如果下标小于0直接返回
        if (index < 0) {
            return -1;
        }
        //如果下标小于10，直接返回下标的值
        if (index < 10) {
            return index;
        }
        //当前下标
        int curIndex = 10;
        //当前位数
        int length = 2;
        //前一位的边界值
        int boundNum = 10;
        //目标下标超过当前位数的下标范围，执行循环
        while (curIndex + lengthSum(length) < index) {
            //当前下标加上当前位的下标数
            curIndex += lengthSum(length);
            //边界数
            boundNum *= 10;
            //下移位数
            length++;
        }
        int addNum = (index - curIndex) / length;
        //目标下标的数所在的数
        int curNum = boundNum + addNum;
        //返回其中的数
        return Integer.toString(curNum).charAt(index - curIndex - addNum * length) - '0';
    }

    /**
     * 根据当前位计算出当前位所有数字占有的位数
     * @param length
     * @return
     */
    private int lengthSum(int length) {
        int count = 9;
        for (int i = 1; i < length; i++) {
            count *= 10;
        }
        return count * length;
    }
}
