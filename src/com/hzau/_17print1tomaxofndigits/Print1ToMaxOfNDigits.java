package com.hzau._17print1tomaxofndigits;

import java.util.Arrays;

/**
 * @description: 面试题：打印从1到最大的位数
 * @author: Dafengsu
 * @date: 2019/8/5
 */
public class Print1ToMaxOfNDigits {

    /**
     * 直接打印的方法
     * @param n
     */
    public void print1ToMaxOfNDigits(int n) {
        int number = 1;
        int i = 0;
        while (i++ < n) {
            number *= 10;
        }
        for (i = 1; i < number; i++) {
            System.out.print(i + " ");
        }
    }

    /**
     * 方法2：先转字符数组，在用字符数组模拟计算
     * @param n
     */
    public void print1ToMaxOfNDigits2(int n) {
        //如果数字小于0,直接返回
        if (n < 0) {
            return;
        }
        char[] number = new char[n];
        Arrays.fill(number,'0');
        while (!Increment(number)) {
            printNumber(number);
        }
    }

    /**
     * 利用字符数组模拟递增运算
     * @param number    字符数组
     * @return  看是否溢出
     */
    private boolean Increment(char[] number) {
        //是否超出的标识符
        boolean isOverflow = false;
        //标记此次计算前一位数是否已经满10，如果是的后一位数+1
        int nTakeOver = 0;
        //字符数组的长度
        int nLength = number.length;
        //从数组最后一位也就是数字的第一位开始遍历
        for (int i = nLength - 1; i >= 0; i--) {
            //当前位数的值，等于上次计算时的值加上是前一位是否要进位
            int nSum = number[i] - '0' + nTakeOver;
            //如果当前位置是个位，个位值加1
            if (i == nLength - 1) {
                nSum++;
            }
            //如果当前位置满10，需进行进位处理
            if (nSum >= 10) {
                //如果当前位置已经是最高位，isOverflow返回true
                if (i == 0) {
                    isOverflow = true;
                } else {
                    //当前位的数值直接记为0
                    nSum =0;
                    //后一位的数值加1
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                //如果各位不满10,直接对各位赋值，并且跳出当前循环（
                //后面位数的数值不需要计算）
                number[i] = (char) ('0' + nSum);
                break;
            }

        }
        return isOverflow;
    }

    /**
     * 数字排列的解法
     * @param n 位数
     */
    public void print1ToMaxOfNDigits3(int n) {
        //如果小于0直接返回
        if (n <= 0) {
            return;
        }
        //创建数组
        char[] number = new char[n];
        //从最大一位，也就是数组的第一位开始排列,遍历
        /*for (int i = 0; i < 10; i++) {
            //设置数组第一位的值，也就是数值最大一位的值
            //从0遍历到9
            number[0] = (char) (i + '0');
            //递归遍历后面位数的值，同时打印
            print1ToMaxOfNDigitsRecursively(number, n, 0);
        }*/
        print1ToMaxOfNDigitsRecursively2(number, n, 0);
    }

    /**
     * 递归遍历输出
     * @param number   数组
     * @param length   数组长度
     * @param index    当前遍历数组的下标
     */
    private void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        //如果递归遍历到最后一位，直接返回并打印
        if (index == length - 1) {
            printNumber(number);
            return;
        }
        //遍历当前数值的所有课能数（从0到9）
        for (int i = 0; i < 10; i++) {
            //给当前位复制
            number[index + 1] = (char) (i + '0');
            //遍历后面的位的数的值
            print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    /**
     * 把所有遍历递归都放在递归方法中
     * @param number    数组
     * @param length    数组长度
     * @param index     当前数组位
     */
    private void print1ToMaxOfNDigitsRecursively2(char[] number, int length, int index) {
        //如果递归遍历到最后一位，直接返回并打印
        if (index > length - 1) {
            printNumber(number);
            return;
        }
        //遍历当前数值的所有可能数（从0到9）
        for (int i = 0; i < 10; i++) {
            //给当前位复制
            number[index] = (char) (i + '0');
            //遍历后面的位的数的值
            print1ToMaxOfNDigitsRecursively2(number, length, index + 1);
        }
    }

    /**
     * 把字符数组按字符串格式打印出来（省略前面的0）
     * @param number
     */
    private void printNumber(char[] number) {
        //当前位置之前是否为0
        boolean isBeginning0 = true;
        //字符数组长度
        int nLength = number.length;
        for (int i = 0; i < nLength; i++) {
            //如果前一位数值为0，且当前位置不为0,或者已经是最后一位
            if (isBeginning0 && number[i] != '0' || i == nLength - 1) {
                isBeginning0 = false;
            }
            //当前位置开始不再为0开始打印
            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
}
