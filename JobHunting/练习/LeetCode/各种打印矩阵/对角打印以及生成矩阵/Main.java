package LeetCode.各种打印矩阵.对角打印以及生成矩阵;

import java.util.Arrays;

/**
 * Created by ChenXiang
 * 2019/09/10,16:58
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 从左上角第一个开始，应该输出1 5 2 3 6 9 13 10 7 4 8 11 14 15 12 16
 * <p>
 * 只有按照这种顺序生成矩阵的题，没有按照这种顺序进行输出的例子，但是实际过程是相似的，下面是一个5*5的矩阵生成
 * 第0组
 * 第1组
 * 第2组
 * 第3组
 * 第4组
 * 第5组
 * 第6组
 * 第7组
 * 第8组
 * 1    
 * 2 3
 * 4 5 6
 * 7 8 9 10
 * 11 12 13 14 15
 * 16 17 18 19
 * 20 21 22
 * 23 24
 * 25
 * (0,0)
 * (1,0)   (0,1)
 * (0,2)   (1,1)   (2,0)
 * (3,0)   (2,1)   (1,2)   (0,3)
 * (0,4)   (1,3)   (2,2)   (3,1)   (4,0)
 * (4,1)   (3,2)   (2,3)   (1,4)
 * (2,4)   (3,3)   (4,2)
 * (4,3)   (3,4)
 * (4,4)
 * 左上角的半个表格（以对角线分界）的横坐标和纵坐标从0开始，每一组增1，直到增至表格的边界（n - 1），而且是交替的，也
 * 就是说，偶数行是列增，行减小，行+列=组的索引。
 * 而右下角的4组数字虽然行、列也是交替增长的，但递减的行或列总是从(n - 1)开始，
 * 而递增的行或列总是从index - n + 1开始，其中index表示组的索引。这就可以得出一个算法
 */
public class Main {
    public static void main(String[] args) {
//        int n = 5;
//        int[][] arr = getGrid(n);
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(findDiagonalOrder(arr)));
    }

    public static int[][] getGrid(int n) {
        int[][] arr = new int[n][n];
        int row = 0, col = 0, m = 1;
        //用于控制奇偶组，false表示偶组，true表示奇组
        boolean isRow = false;
        //i表示当前组的索引，从0开始
        for (int i = 0; i < (2 * n - 1); i++) {
            row = i;
            while (row >= ((i < n) ? 0 : i - n + 1)) {
                //如果处理的是右下角表格中的数字，行和列最大不能超过n-1
                if (row > (n - 1)) {
                    row = n - 1;
                }
                col = i - row;
                if (isRow) {
                    arr[row][col] = m;
                } else {
                    //行改列，列改行
                    arr[col][row] = m;
                }
                m++;
                row--;
            }
            isRow = !isRow;
        }
        return arr;
    }


    //https://leetcode-cn.com/problems/diagonal-traverse/solution/dui-jiao-xian-bian-li-gui-lu-xiang-xi-jie-xi-by-ji/
    public static int[] findDiagonalOrder(int[][] matrix) {
        //还要考虑输入数组为空时的情况
        if (matrix.length == 0) {
            return new int[]{};
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];

        /**
         * 当对角线的序号为偶数时，对角线是向右上的，称对角线为curve_line
         * 在一条对角线上，行和列的序号加起来是恒定的，因为如果行 +1 了则列必定 -1。
         * 如果找到了行（或列）的起始与结束范围，列的就迎刃而解，这题就好做了。
         * 对角线是从0开始计数的，行数是实际的行数
         *
         * 行的起始：
         * 在对角线小于等于列数的时候，观察到始终是从第 ０ 行开始。
         * 超过了列数后，每超过一条，起始行数也要加一。
         * 超过后的起始即 curve_line + 1 - cols。
         * 注意对角线是从 ０ 开始计数的，而行数是实打实的。
         *
         * 行的结束：
         * 从最后一行看，当对角线数大于等于行数时，观察到始终到第M行结束，即索引为 M-1。
         * 当对角线小于行数时，观察到每少一条，结束行数也 -1。
         * 对角线小于行数的结束点是 curve_line。
         */

        int idx = 0;
        for (int curveLine = 0; curveLine < rows + cols - 1; curveLine++) {
            int rowBegin = curveLine + 1 <= cols ? 0 : curveLine + 1 - cols;
            int rowEnd = curveLine + 1 >= rows ? rows - 1 : curveLine;
            if (curveLine % 2 == 1) {
                for (int i = rowBegin; i <= rowEnd; i++) {
                    result[idx++] = matrix[i][curveLine - i];
                }
            } else {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result[idx++] = matrix[i][curveLine - i];
                }
            }
        }
        return result;

    }

}
