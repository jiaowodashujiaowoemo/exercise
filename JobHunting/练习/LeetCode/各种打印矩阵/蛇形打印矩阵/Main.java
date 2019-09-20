package LeetCode.各种打印矩阵.蛇形打印矩阵;

/**
 * Created by ChenXiang
 * 2019/09/10,16:07
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * <p>
 * 输出1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * <p>
 * 一圈一圈打印，从外到内，我们确定一个矩形，通常通过左上角的坐标和右下角的坐标即可，即（tR，tC）和（dR，dC），
 * 我们先写出打印一圈的方法，然后循环调用，
 * 如果我们发现左上角的坐标跑到了右下角坐标的右边或者下边，整个过程就停止，这样额外的空间复杂度是O(1)
 *
 * 还有一个是给定矩阵大小，比如4，然后打印
 * 1  2  3  4
 * 12 13 14 5
 * 11 16 15 6
 * 10 9  8  7
 * 相当于按照上面的顺序生成一个矩阵
 */
public class Main {
    static int num=1;
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int row1 = 0, col1 = 0, row2 = nums.length - 1, col2 = nums[0].length - 1;
        while (row1<=row2&&col1<=col2){
            printEdge(nums,row1++,col1++,row2--,col2--);
        }

        System.out.println();

        int n=3;
        int[][] arr=new int[n][n];
        row1=col1=0;
        row2=col2=n-1;
        while (row1<=row2&&col1<=col2){
            generateEdge(arr,row1++,col1++,row2--,col2--);
        }
        //生成之后进行输出
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void printEdge(int[][] nums, int row1, int col1, int row2, int col2) {
        //只有一行和只有一列的情况，可以看做是返回条件
        if (row1==row2){
            for (int i=col1;i<=col2;i++){
                System.out.println(nums[row1][i]+" ");
            }
        }else if (col1==col2){
            for (int i=row1;i<row2;i++){
                System.out.println(nums[i][col1]+" ");
            }
        }else {
            int curR=row1;
            int curC=col1;
            while (curC!=col2){
                System.out.print(nums[curR][curC++]+" ");
            }
            while (curR!=row2){
                System.out.print(nums[curR++][curC]+" ");
            }
            while (curC!=col1){
                System.out.print(nums[curR][curC--]+" ");
            }
            while (curR!=row1){
                System.out.print(nums[curR--][curC]+" ");
            }
        }
    }

    private static void generateEdge(int[][] nums,int row1,int col1,int row2,int col2){
        if (row1==row2){
            /**
             * 这种情况是党length为奇数时应该怎么处理最中间元素的问题
             * 比如，在n=3时，得到的元素是
             * 1 2 3
             * 8 0 4
             * 7 6 5
             * 如果没有处理的话，中间元素就是0
             */
            nums[row1][col1]=num;
        }else {
            int curR=row1;
            int curC=col1;
            while (curC!=col2){
                nums[curR][curC++]=num++;
            }
            while (curR!=row2){
                nums[curR++][curC]=num++;
            }
            while (curC!=col1){
                nums[curR][curC--]=num++;
            }
            while (curR!=row1){
                nums[curR--][curC]=num++;
            }
        }
    }
}

class Solution {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }
}