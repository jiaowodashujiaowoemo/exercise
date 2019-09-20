import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/15,16:38
 */
public class Mainbd3 {
    public static void main(String[] args) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
//        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
//            list.add(scanner.nextInt());
            arr[i]=scanner.nextInt();
        }
        if (arr.length==0){
            System.out.println(0);
            return;
        }
//        System.out.println(Arrays.toString(arr));
        int i=0,j=n-1;
        int turn=1;
        while (i<=j){
            int max=0;
            if (arr[i]>=arr[j]){
                max=arr[i];
                i++;
            }else {
                max=arr[j];
                j--;
            }
            if (turn%2==1){
                result+=max;
            }
            turn++;
        }
//        if (list.size()==0){
//            System.out.println(0);
//            return;
//        }
//        int j = 1;

//        while (!list.isEmpty()) {
//            int max = Math.max(list.get(0), list.get(list.size() - 1));
//            if (j % 2 == 1) {
//                result += max;
//                j++;
//            }
//            if (list.get(0) == max) {
//                list.remove(0);
//            } else {
//                list.remove(list.size() - 1);
//            }
//        }
        System.out.println(result);
//        int[] clone = new int[n];
//        for (int i = 0; i < n; i++) {
//            int x = scanner.nextInt();
//            arr[i] = x;
//            clone[n - i - 1] = x;
//        }
//
//        int result = 0;
//        int i = 0;
//        int j = 1;
//        while (i != n / 2) {
//            if (arr[i] >= arr[n - i - 1]) {
//                if (j % 2 == 1) {
//                    result += arr[i];
//                } else {
//                    j++;
//                }
//
//            } else {
//                if (j % 2 == 1) {
//                    result += arr[n - i - 1];
//                } else {
//                    j++;
//                }
//            }
//            i++;
//        }
//        System.out.println(result);
    }
}
