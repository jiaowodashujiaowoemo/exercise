package 第二题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/11,15:51
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int L=scanner.nextInt();
        int N=scanner.nextInt();

        int[] arr=new int[N];


        for (int i=0;i<N;i++){
            arr[i]=scanner.nextInt();
        }

        int reverse=0;
        int order=0;

        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                if (Math.abs(arr[i]-arr[j])>L/2){
                    reverse++;
                }else {
                    order++;
                }
            }
        }
        if (reverse>order){
            for (int i=0;i<N;i++){
                if (arr[i]>L/2){
                    arr[i]=arr[i]-L;
                }
            }
        }

        Arrays.sort(arr);

        int count=0;
        int holding=arr[N/2];
        for (int i=0;i<arr.length;i++){
            int  times=Math.abs(arr[i]-holding)-1-(Math.abs(i-N/2)-1);
            count+=times;
        }
        System.out.println(count);

    }

}
