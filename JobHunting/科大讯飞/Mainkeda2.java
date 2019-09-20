import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/12,10:23
 * aaabb -> 2a3b
 */
public class Mainkeda2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(compress(str));
    }

    public static String compress(String string) {
        if (string.matches(".*\\d+.*")) {
            return null;
        }
        char[] arr = string.toCharArray();
        int result = 1;
        char ch = arr[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ch) {
                result++;
            } else {
                if (result > 1) {
                    sb.append(result + (arr[i - 1] + ""));
                } else {
                    sb.append(arr[i - 1] + "");
                }
                result = 1;
                ch = arr[i];
            }
        }
        if (result > 1) {
            sb.append(result + (arr[arr.length - 1] + ""));
        } else {
            sb.append(arr[arr.length - 1] + "");
        }
        return sb.toString();
    }
}
