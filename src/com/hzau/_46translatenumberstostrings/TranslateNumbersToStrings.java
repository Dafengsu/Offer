package com.hzau._46translatenumberstostrings;

/**
 * @description:    面试题46：把数字翻译成字符串
 * @author: Dafengsu
 * @date: 2019/8/19
 */
public class TranslateNumbersToStrings {
    /**
     * 递归的方法
     * @param number
     * @return
     */
    public int getTranslationCount(int number) {
        if (number < 0) {
            return 0;
        }
        String strNum = String.valueOf(number);
        return getTranslationCountCore(0, strNum);
    }

    private int getTranslationCountCore(int index, String strNum) {
        if (index >= strNum.length()) {
            return 1;
        }
        int count = 0;
        count += getTranslationCountCore(index + 1, strNum);
        if (index + 1 < strNum.length() && Integer.parseInt(strNum.substring(index, index + 2)) < 26 && Integer.parseInt(strNum.substring(index, index + 2)) > 9) {
            count += getTranslationCountCore(index + 2, strNum);
        }
        return count;
    }

    /**
     * 非递归的方法
     * @param number
     * @return
     */
    public int getTranslationCount2(int number) {
        //如果数小于0，直接返回
        if (number < 0) {
            return 0;
        }
        int count = 0;
        //把数字转成字符串
        String strNumber = String.valueOf(number);
        int length = strNumber.length();
        int[] counts = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            count = 0;
            //如果是最后一个直接为1，否则继承前一个
            if (i < length - 1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }
            if (i < length - 1) {
                int digit1 = strNumber.charAt(i) - '0';
                int digit2 = strNumber.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                //如果两位数在10到25之间
                if (converted > 9 && converted <= 25) {
                    //如果当前位小于倒数第二位
                    if (i < length - 2) {
                        count += counts[i + 2];
                        //如果当前位就是倒数第二位
                    } else {
                        count += 1;
                    }
                }
            }
            counts[i] = count;
        }
        return counts[0];
    }
}
