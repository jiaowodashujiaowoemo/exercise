package 海康;

import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/24,15:22
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int type = scanner.nextInt();
        System.out.println(Cal(a, b, type) % Integer.MAX_VALUE);
    }

    public static int Cal(int a, int b, int type) {
        int c = 0;
        switch (type) {
            case 1:
                for (int i = 0; i < b; i++) {
                    c = c + a;
                }
                break;
            case 0:
                if (b == 0) {
//                    System.out.println("除数不能为0");
                    c = 0;
                }
                if (a == 0 || a < b) {
                    c = 0;
                }
                c = 0;
                while (a > b) {
                    c++;
                    a = a + (~b) + 1;
                }
                break;
            case -1:
                c = a + (~b) + 1;
                break;
            default:

        }
        return c;
    }
}
