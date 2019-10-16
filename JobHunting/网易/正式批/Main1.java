package 正式批;

import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/21,15:29
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        solution(arr);
    }

    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String result = "";
            int tmp = arr[i];
            while (tmp >= 10) {
                result = "9" + result;
                tmp = tmp - 9;
            }
            if (tmp != 0) {
                result = tmp + result;
            }
            System.out.println(result);
        }
    }
}
