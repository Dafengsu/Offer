package com.hzau._10fibonacci;

/**
 * @description: 面试题10：实现斐波那契数列
 * @author: Dafengsu
 * @date: 2019/7/31
 */
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int res = fibonacci.fibonacci2(4);
        System.out.println(res);
    }

    /**
     * 循环求斐波那契数列
     *
     * @param n 第几项
     * @return
     */
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fN2 = 0;
        int fN1 = 1;
        int fN = 0;
        for (int i = 2; i <= n; i++) {
            fN = fN1 + fN2;
            fN2 = fN1;
            fN1 = fN;
        }
        return fN;

    }

    /**
     * 矩阵斐波拉契求解
     * 数学公式：
     * |f(n),f(n-1)  | = |  1,  1  |(n-1)
     * |f(n-1),f(n-2)|   |  1,  0 |
     * @param n 第几项
     * @return 返回值
     */
    public int fibonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return MatrixPower(n - 1).m00;
    }

    public Matrix MatrixPower(int n) {
        Matrix matrix;
        if (n == 1) {
            matrix = new Matrix(1, 1, 1, 0);
        } else if (n % 2 == 0) {
            matrix = MatrixPower(n / 2);
            matrix = MatrixMultiply(matrix, matrix);
        } else {
            matrix = MatrixPower((n - 1) / 2);
            matrix = MatrixMultiply(matrix, matrix);
            matrix = MatrixMultiply(matrix, new Matrix(1, 1, 1, 0));
        }
        return matrix;
    }
    /**
     * 两个矩阵相乘的方法
     * @param matrix1
     * @param matrix2
     * @return
     */
    public Matrix MatrixMultiply(Matrix matrix1, Matrix matrix2) {

        return new Matrix(  matrix1.m00 * matrix2.m00 + matrix1.m01 * matrix2.m10,
                matrix1.m00 * matrix2.m01 + matrix1.m01 * matrix2.m11,
                matrix1.m10 * matrix2.m00 + matrix1.m11 * matrix2.m10,
                matrix1.m10 * matrix2.m01 + matrix1.m11 * matrix2.m11);
    }

    /**
     * 内部类构建矩阵
     */
    class Matrix {
        int m00;
        int m01;
        int m10;
        int m11;

        public Matrix(int m00, int m01, int m10, int m11) {
            this.m00 = m00;
            this.m01 = m01;
            this.m10 = m10;
            this.m11 = m11;
        }

    }

}
