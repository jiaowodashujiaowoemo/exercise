package 春招.三六零.组队吃鸡;

import java.util.Scanner;

/**
 * @Description
 * @Author ChenXiang
 * @Date 2019/04/03,20:13
 */
public class Main {
    public static int[] solution() {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int[][] arr = new int[t][4];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] result=new int[t];
        for (int i = 0; i < t; i++) {
            result[i]+=arr[i][3];
            if (arr[i][0]!=0&&arr[i][2]!=0){
                result[i]+=Math.min(arr[i][0],arr[i][2]);
                arr[i][0]=Math.abs(arr[i][0]-arr[i][2]);
                arr[i][2]=arr[i][0];
            }
            result[i]+=arr[i][1]/2;
            arr[i][1]=arr[i][1]%2;
            if (arr[i][0]>=2&&arr[i][1]==1){
                result[i]+=Math.min(arr[i][0]/2,arr[i][1]);
            }
            result[i]+=arr[i][0]/4;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result=solution();
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
