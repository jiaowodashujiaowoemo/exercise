package 正式批;

import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/21,16:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] result = new int[T];
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            result[i] = find(arr);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(result[i]);
        }
    }

    private static int find(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = 0;
            int count = 1;
            for (int j = i; j < arr.length - 1; j++) {
                sum = sum + arr[j];
                if (arr[j + 1] < sum) {
                    break;
                }
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
