package 华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/21,19:19
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = low; i < high; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (i == j) {
                        nums.add(i);
                    }
                    if (i > j) {
                        break;
                    }
                } else {
                    if (j == i / 2) {
                        nums.add(i);
                    }
                }
            }
        }
        if (nums.size() == 0) {
            System.out.println(0);
            return;
        }

        int b = 0;
        int a = 0;
        for (int i = 0; i < nums.size(); i++) {
            int ge = nums.get(i) % 10;
            int tmp = nums.get(i) / 10;
            int shi = tmp % 10;
            a += shi;
            b += ge;
        }

        System.out.println(Math.min(a, b));
    }
}
