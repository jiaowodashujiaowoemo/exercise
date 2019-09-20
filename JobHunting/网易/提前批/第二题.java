package 提前批;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/03,16:51
 */
public class 第二题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int ns[] = new int[t];
        long[][] nums = new long[t][100000];
        if (t >= 1 && t <= 10) {
            for (int i = 0; i < t; i++) {
                ns[i] = scanner.nextInt();
                for (int j = 0; j < ns[i]; j++) {
                    nums[i][j] = Long.parseLong(scanner.next());
                }
                Arrays.sort(nums[i]);
            }

            for (int i = 0; i < t; i++) {
                int length = nums[i].length - 1;
                if (nums[i][length] >= nums[i][length - 1] + nums[i][length - 2]) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}
