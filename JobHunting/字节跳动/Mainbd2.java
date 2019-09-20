import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/15,16:32
 */
public class Mainbd2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextLong();
            arr[i][1] = scanner.nextLong();
        }
        long time = arr[0][0];
        long count = arr[0][1];
        long maxCount = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] - arr[i - 1][0] <= arr[i - 1][1]) {
                time = time + arr[i - 1][1];
                count = count + arr[i][1] - (arr[i][0] - arr[i - 1][0]);
                maxCount = Math.max(count, maxCount);
            } else if (arr[i][0] - arr[i - 1][0] <= (count + arr[i][1] - (arr[i][0] - arr[i - 1][0])) && arr[i][0] - arr[i - 1][0] > arr[i - 1][1]) {
                time = time + arr[i - 1][1];
                count = count + arr[i][1] - (arr[i][0] - arr[i - 1][0]);
                maxCount = Math.max(count, maxCount);
            } else {
                time = arr[i][0];
                count = arr[i][1];
                maxCount = Math.max(maxCount, count);
            }
        }
        time=time+arr[n-1][1];
        System.out.println(time + " " + maxCount);
    }

}
