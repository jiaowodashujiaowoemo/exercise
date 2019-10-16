package 正式批;

import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/21,15:46
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] arr = new long[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            arr[i][2] = scanner.nextInt();
            arr[i][3] = scanner.nextInt();
        }
        solution(arr);
    }

    public static void solution(long[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int result = 0;
            long a = arr[i][0], b = arr[i][1], p = arr[i][2], q = arr[i][3];
            while (a + p < b) {
                p = p * q;
                result++;
            }
            result++;
            System.out.println(result);
        }
    }
}
