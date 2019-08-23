package com.hzau._05replacepaces;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/25
 */
public class ReplaceSpaces {
    /**
     * 替换空格
     * @param stringBuffer 待替换的字符串
     * @return 替换后的字符串
     */
    public String replaceSpaces(StringBuffer stringBuffer) {
        //排除空字符串
        if (stringBuffer == null) {
            return null;
        }
        if (stringBuffer.toString().equals("")) {
            return "";
        }
        //字符串长度
        int length = stringBuffer.length();
        //字符串中的空格数
        int count = 0;
        //统计字符串中的空格数
        for (int i = 0; i < length; i++) {
            if (stringBuffer.charAt(i) == ' ') {
                count++;
            }
        }
        //设置字符串的新长度
        stringBuffer.setLength(length + 2 * count);
        //从后面开始替换
        for (int i = length - 1; i >= 0; i--) {
            if (stringBuffer.charAt(i) == ' ') {
                stringBuffer.setCharAt(i + count * 2, '0');
                stringBuffer.setCharAt(i + count * 2 - 1, '2');
                stringBuffer.setCharAt(i + count * 2 - 2, '%');
                count--;
            } else {
                stringBuffer.setCharAt(i + 2 * count, stringBuffer.charAt(i));
            }
        }
        //返回字符串
        return String.valueOf(stringBuffer);
    }
}
