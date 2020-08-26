package com.dfs._61_continouscards;

import java.util.Arrays;

/**
 * @description:    面试题61：扑克牌中的顺子
 * @author: Dafengsu
 * @date: 2019/8/22
 */
public class ContinousCards {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int length = numbers.length;
        Arrays.sort(numbers);
        int numberOfZero = 0;
        int numberOfGap = 0;
        for (int i = 0; i < length && numbers[i] == 0; i++) {
            numberOfZero++;
        }
        int small = numberOfZero;
        int big = small + 1;
        while (big < length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }
            numberOfGap += numbers[big++] - numbers[small++] - 1;
        }

        return numberOfZero >= numberOfGap;
    }

    /**
     * 创建一个数组记录排出现的次数用来排除对子，然后比较最大值和最小值
     * @param numbers
     * @return
     */
    public boolean isContinuous2(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        byte[]data = new byte[14];
        int max = -1;
        int min = 14;
        for (int number : numbers) {
            data[number]++;
            if (number == 0) {
                continue;
            }
            if (data[number] > 1) {
                return false;
            }
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }

        }
        return max - min < 5;
    }

    /**
     * 位运算
     * @param numbers
     * @return
     */
    public boolean isContinuous3(int [] numbers) {
        if(numbers.length != 5) {
            return false;
        }
        int min = 14;
        int max = -1;
        int flag = 0;
        for(int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if(number == 0) {
                continue;
            }
            //如果flag的第number位bit已经为1，则已经出现过这个数了
            if(((flag >> number) & 1) == 1) {
                return false;
            }
            //位运算使得flag的第number位bit位为1
            flag |= (1 << number);
            if(number > max) {
                max = number;
            }
            if(number < min) {
                min = number;
            }
        }
        return max - min < 5;
    }
}
