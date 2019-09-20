package 提前批;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/03,15:56
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //班级人数
        int n = scanner.nextInt();
        //成绩数组
        int[] a = new int[n];
        float[] temp = new float[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            temp[i] = a[i];
        }
        //询问的次数
        int times = scanner.nextInt();
        //每个人的百分数
        int[] result = new int[times];

        Arrays.sort(temp);

        for (int i = 0; i < times; i++) {
            int score = (int) a[scanner.nextInt() - 1];
            int j = 0;
            for (; j < n; j++) {
                if (score < temp[j]) {
                    break;
                }
            }
            result[i] = j - 1;
        }

//        for (int i = 1; i <= q; i++) {
//            for (int m = 0; m < n; m++) {
//                if (a[i-1] < temp[m]) {
//                    continue;
//                } else {
//                    result[i - 1] = Double.valueOf(((n - m - 1) / n));
//                    break;
//                }
//            }
//        }

        for (int m = 0; m < times; m++) {
//            System.out.println(String.format("%.6f",result[m].doubleValue()));
            BigDecimal b = new BigDecimal(result[m]).multiply(new BigDecimal(100));
            BigDecimal divisor = new BigDecimal(n);
            b = b.divide(divisor, 6, BigDecimal.ROUND_HALF_UP);
            System.out.println(b);
        }
    }
}
