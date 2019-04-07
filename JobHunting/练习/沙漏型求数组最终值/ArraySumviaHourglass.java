package 沙漏型求数组最终值;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Description 给定i==j(0<=i,j<=6)的二维数组，将沙漏型的子集
 * a    b   c
 *      d
 * e    f   g
 * 求和后，组成新的数组。。。如此下去，求出最后的和
 * 一个6*6的数组有16个沙漏型子集
 * @Author ChenXiang
 * @Date 2019/02/28,13:54
 */

/**
 * 该题有问题，因为如果初始化的数组长度是偶数，到最后一定是一个二维数组，但是没有定义二维数组后的计算应该是怎样，反正大概的过程就是这样
 */
public class ArraySumviaHourglass {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int[][] arr = new int[6][6];
//
//        for (int i = 0; i < 6; i++) {
//            String[] arrRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 6; j++) {
//                int arrItem = Integer.parseInt(arrRowItems[j]);
//                arr[i][j] = arrItem;
//            }
//        }

        int[][] arr = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        int result = new ArraySumviaHourglass().hourglassSum(arr);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }

    //直接把3*3的数组传递进来，再求和
    public static int getSum(int[][] arr) {
        int sum = 0;
        if (3 == arr.length) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sum += arr[i][j];
                }
            }
        }
        //减去两腰
        return sum - arr[1][0] - arr[1][2];
    }

    //初始化并返回一个下一级的二维数组
    public static int[][] createNextArr(int[][] arr) {
        //二维数组的length返回数组的行数，此题中数组是个方阵，需要得到下一个数组的大小
        int size = arr.length - 2;
        int[][] arrNext = new int[size][size];
        return arrNext;
    }

    // Complete the hourglassSum function below.
    int hourglassSum(int[][] arr) {
        int[][] tmpArr = arr;//第一次是输入的数组，后面每一次是由和组成的数组
        int[][] sumArr = new int[3][3];//表示包含沙漏的3*3的数组
        while (tmpArr.length>=5) {
            int[][] newArr = createNextArr(tmpArr);
            for (int i = 0; i + 3 <= tmpArr.length; i++) {
                for (int j = 0; j + 3 <= tmpArr.length; j++) {
                    for (int m = 0; m <= 2; m++) {
                        for (int n = 0; n <= 2; n++) {
                            sumArr[m][n] = tmpArr[i + m][n + j];
                        }
                    }
                    newArr[i][j] = getSum(sumArr);
                }
            }
            tmpArr = newArr;
        }
        return getSum(tmpArr);
    }
}
