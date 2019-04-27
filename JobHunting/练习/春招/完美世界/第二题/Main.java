package 春招.完美世界.第二题;

import java.util.Scanner;

/**
 * @Description 二维数组左上角到右下角，每个位置一个数进行相加（可正可负），要求每个位置运算后的结果都不能小于1，求初始血量至少是多少
 * @Author ChenXiang
 * @Date 2019/04/15,20:21
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
    }

    public static int getMinVol(int[][] val) {
        int x = val.length;
        int y = val[0].length;
        int[][] dp = new int[x][y];
        dp[x - 1][y - 1] = Math.max(1 - val[x - 1][y - 1], 1);
        for (int i = y - 1; i > 0; i--)
            dp[x - 1][i - 1] = Math.max(dp[x - 1][i] - val[x - 1][i - 1], 1);
        for (int i = x - 1; i > 0; i--)
            dp[i - 1][y - 1] = Math.max(dp[i][y - 1] - val[i - 1][y - 1], 1);
        for (int i = x - 2; i >= 0; i--) {
            for (int j = y - 2; j >= 0; j--) {
                int down = Math.max(dp[i + 1][j] - val[i][j], 1);
                int right = Math.max(dp[i][j + 1] - val[i][j], 1);
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0];
    }
}
