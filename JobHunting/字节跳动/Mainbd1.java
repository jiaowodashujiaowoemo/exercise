import sun.security.util.Length;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/15,16:04
 */
public class Mainbd1 {
    static int num=0;
    static List<Integer> tmp=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int k = scanner.nextInt();
        int len=n-1;
        for (int i=len;i>1;i--){
            if (arr[0]+arr[1]+arr[len]<k){
                break;
            }else {
                len--;
            }
        }
        getResult(0,3,arr,k);
        System.out.println(num);
    }

    public static void getResult(int index,int p,int[] arr,int k){
        if (p==1){
            for (int i=index;i<arr.length;i++){
                tmp.add(arr[i]);
                if (tmp.get(0)+tmp.get(1)+tmp.get(2)<k){
                    num++;
                }
                tmp.remove((Object)arr[i]);
            }
        }else if (p>1){
            for (int i=index;i<=arr.length-p;i++){
                tmp.add(arr[i]);
                getResult(i+1,p-1,arr,k);
                tmp.remove((Object)arr[i]);
            }
        }else {
            return;
        }
    }
//    public static int getNum(int[] arr, int target) {
//        int result = 0;
//        if (arr == null | arr.length == 0) {
//            return result;
//        }
//        for (int i = 0; i < arr.length - 2; i++) {
//            if (arr[i] >= target) {
//                break;
//            } else {
//                for (int j = i + 1; j < arr.length - 1; j++) {
//                    if (arr[i] + arr[j] >= target) {
//                        break;
//                    } else {
//                        for (int k = j + 1; k < arr.length; k++) {
//                            if (arr[i] + arr[j] + arr[k] >= target) {
//                                break;
//                            } else {
//                                result++;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
