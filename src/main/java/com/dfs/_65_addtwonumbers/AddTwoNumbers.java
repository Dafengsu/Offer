package com.dfs._65_addtwonumbers;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/22
 */
public class AddTwoNumbers {
    /**
     * 位运算
     * @param num1
     * @param num2
     * @return
     */
    public int add(int num1,int num2) {
        int sum, carry;
        do {
            //计算各bit位直接相加后的值（不管进位）
            sum = num1 ^ num2;
            //计算可能产生进位的bit位，左移一位进位，形成进位值。
            carry = (num1 & num2) << 1;
            //继续循环，知道不产生进位为止.
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }
}
