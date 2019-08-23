package com.hzau._15numberof1inbinary;

/**
 * @description:  面试题15：二进制中1的个数
 *  题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 *  把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 * @author: Dafengsu
 * @date: 2019/8/1
 */
public class NumberOf1InBinary {
    /**
     * 为了应对负数的情况，不移动目标数，把标识数往左移动。
     * @param n
     * @return
     */
    public int numberOf11(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 巧妙的算法：
     * 把一个整数减去1，就会把其二进制的数从最右边一个1到最右边的数取反，
     * 如1110100，减去1是1110011，从右数第一位到第三位（第一个1的位置），
     * 全部取反了，这是再把1110011与1110100进行与运算，结果就是1110000
     * 这样就相当消除掉了右边第一1，持续运算，直到所有的1都消除
     * @param n
     * @return
     */
    public int numberOf12(int n) {
        //统计数
        int count = 0;
        //当n不为0时进行运算
        while (n!=0)
        {   //运算一次统计数加1
            ++count;
            //消除最右边的1的运算
            n = (n - 1) & n;
        }
        return count;
    }
}
