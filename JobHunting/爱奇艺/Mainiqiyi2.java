import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/08,15:36
 */
public class Mainiqiyi2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextInt();
        double m = scanner.nextInt();
        double result = 0.0;
        double blue = 1;
        System.out.println(String.format("%.5f", calculate(n, m, result, blue)));
    }

    public static double calculate(double n, double m, double result, double blue) {
        if (0 == n) {
            return 0;
        } else if (0 == m && 0 != n) {
            result = blue * 1;
            return result;
        }
        for (int i = 0; i < Math.ceil((n + m) / 3); i++) {
            if (n > 0 && m > 0) {
                result = result + blue * n / (n + m);
                n--;
            }
            if (m > 0) {
                blue = blue * m / (n + m);
                m--;
                result += calculate(n, m, result, blue);
            }
            if (m > 0 && n > 0) {
                blue = blue * m / (n + m);
                m--;
            }
            if (m > 0) {
                blue = blue * m / (n + m);
                m--;
                result += calculate(n, m, result, blue);
            }
            if (n > 0) {
                blue = blue * n / (n + m);
                n--;
                result += calculate(n, m, result, blue);
            }
        }
        return result;
    }
}
