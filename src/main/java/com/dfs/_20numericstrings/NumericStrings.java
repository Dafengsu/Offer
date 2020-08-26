package com.dfs._20numericstrings;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/7
 */
public class NumericStrings {
    //指针
    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length < 1) {
            return false;
        }
        //判断一开始是否存在整数，移动指针
        boolean flag = scanInteger(str);
        //如果有小数点，判断小数点后是否有整数,移动指针
        if (index < str.length && str[index] == '.') {
            index++;
            //只要小数点前后有一个有整数就可以了
            flag = scanUnsignedInteger(str) || flag;
        }
        //如果遇到e,判断e后是否有整数
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            //e前后都必须有正确的数
            flag = scanInteger(str) && flag;
        }
        return flag && index == str.length;
    }

    /**
     * 判断是否存在整数
     * @param str   字符数组
     * @return  是否存在整数
     */
    private boolean scanInteger(char[] str) {
        //如果是’+‘或’-‘直接跳过
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        //判断后面的整数
        return scanUnsignedInteger(str);
    }

    /**
     * 判断遍历无符号整数，移动指针
     * @param str   字符数组
     * @return  是否存在整数
     */
    private boolean scanUnsignedInteger(char[] str) {
        //记录初始指针
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        //是否存在整数
        return start < index;
    }

}
