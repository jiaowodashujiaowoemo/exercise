package 找出数组中缺失的两个数;

import java.util.concurrent.locks.Lock;

/**
 * Created by ChenXiang
 * 2019/09/25,21:40
 * 纯数学题
 * <p>
 * 根据平方和和平方差公式
 * 大小为98的数组，放了1-100中的98个数字，不重复，找出缺失的两个数字
 * 要求时间复杂度为O(N)，空间复杂度为O(1)
 */
public class Solution {
    public static void main(String[] args) {

    }

    public void resolve(int[] arr) {
        //arr.length=98;
        int sumXY = 0, //两数之和
                sumXXYY = 0,  //两数的平方之和
                sum1 = 0, sum2 = 0;
        for (int i = 1; i <= 100; i++) {
            sum1 += i;
            sum2 += i * i;
        }

        for (int i = 0; i < 98; i++) {
            sumXY += arr[i];
            sumXXYY += arr[i] * arr[i];
        }
        sumXY = sum1 - sumXY;
        sumXXYY = sum2 - sumXXYY;

        int xy = (sumXY * sumXY - sumXXYY) / 2;     //两数之积
        int sum_x_y = (int) Math.sqrt(sumXY * sumXY - 4 * xy);     //两数之差

        int x = (sumXY + sum_x_y) / 2;
        int y = (sumXY - sum_x_y) / 2;
    }
}