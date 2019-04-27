package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author ChenXiang
 * @Date 2019/04/09,19:45
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i<n; i++){
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);


    }
}
