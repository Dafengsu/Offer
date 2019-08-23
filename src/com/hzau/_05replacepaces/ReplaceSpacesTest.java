package com.hzau._05replacepaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/7/25
 */
class ReplaceSpacesTest {
    ReplaceSpaces replaceSpaces = new ReplaceSpaces();
    @Test
    void replaceSpaces() {
       test1();
       test2();
       test3();
    }

    @Test
    void replace() {
        String string = "hello word ";
        String s = string.replaceAll(" ", "%20");
        System.out.println(s);
    }

    void test1() {
        StringBuffer stringBuffer = new StringBuffer("hello word ");
        String results = replaceSpaces.replaceSpaces(stringBuffer);
        System.out.println("处理后的结果是"+results);
    }
    void test2() {
        StringBuffer stringBuffer = new StringBuffer(" hello word ");
        String results = replaceSpaces.replaceSpaces(stringBuffer);
        System.out.println("处理后的结果是"+results);
    }

    void test3() {
        StringBuffer stringBuffer = new StringBuffer("");
        String results = replaceSpaces.replaceSpaces(stringBuffer);
        System.out.println("处理后的结果是"+results);
    }
}