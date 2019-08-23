package com.hzau._12stringpathInmatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/1
 */
class StringPathInMatrixTest {
    //创建实例
    StringPathInMatrix stringPathInMatrix = new StringPathInMatrix();
    @Test
    void hasPath() {
        //创建矩阵
        char[][] matrix = {{'A','B','T','G'},
                          {'C','F','C','S'},
                          {'J','D','E','H'},};
        String str = "BFCE";
        boolean b = stringPathInMatrix.hasPath(matrix, str);
        System.out.println(b);
    }
}