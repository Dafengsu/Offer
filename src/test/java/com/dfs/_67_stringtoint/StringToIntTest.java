package com.dfs._67_stringtoint;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/23
 */
class StringToIntTest {
    /**
     * 创建实例
     */
    StringToInt stringToInt = new StringToInt();

    @Test
    void strToInt() {
        String string = "  -2147483649";
        int res = stringToInt.StrToInt(string);
        System.out.println(res);
    }
}
