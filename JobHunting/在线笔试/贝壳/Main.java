package 贝壳;

import java.lang.reflect.InvocationHandler;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/23,20:05
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        int times = next(s);
        String sub = s.substring(times);
        while (--k > 0) {
            s += sub;
        }
        System.out.println(s);
    }

    /**
     *KMP算法求next数组
     * https://www.cnblogs.com/ZuoAndFutureGirl/p/9028287.html
     */
    public static int next(String s) {
        s += "~";
        int n = s.length();
        int[] next = new int[n];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < n - 1) {
            if (k == -1 || s.charAt(j) == s.charAt(k)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next[n - 1];
    }
}
