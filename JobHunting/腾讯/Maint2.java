import java.util.*;

/**
 * Created by ChenXiang
 * 2019/09/01,20:18
 */
public class Maint2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] arr = new long[n][2];
//        Map<Integer,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
//            int a=scanner.nextInt();
//            int b=scanner.nextInt();
//            map.put(a,b);
        }
        Arrays.sort(arr, (o1, o2) -> (int)(o1[1] - o1[0] - (o2[1] - o2[0])));
        for (int i=0;i<n;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[i][0] * i + arr[i][1] * (n - i - 1);
        }
        System.out.println(result);
    }
}
