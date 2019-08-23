package com.hzau._49uglynumber;

/**
 * @description:    面试题49：丑数
 * @author: Dafengsu
 * @date: 2019/8/19
 */
public class UglyNumber {
    public int getUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] numbers = new int[index];
        numbers[0] = 1;
        int nextIndex = 1;
        int number2 = 0;
        int number3 = 0;
        int number5 = 0;
        while (nextIndex < index) {
            numbers[nextIndex]= Math.min(Math.min(numbers[number2] * 2, numbers[number3] * 3), numbers[number5] * 5);
            while (numbers[number2] * 2 <= numbers[nextIndex]) {
                number2++;
            }
            while (numbers[number3] * 3 <= numbers[nextIndex]) {
                number3++;
            }
            while (numbers[number5] * 5 <= numbers[nextIndex]) {
                number5++;
            }
            nextIndex++;
        }
        return numbers[index - 1];
    }
}
