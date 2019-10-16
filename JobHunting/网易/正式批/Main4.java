package 正式批;

import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/21,16:06
 */
public class Main4 {
    static int sum=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        InversePairs(arr);
    }

    public static void InversePairs(int[] array) {
        if (array.length == 0 || array == null) {
            System.out.println(0);
        }
        int[] copy = array.clone();
        mergeSort(array, copy, 0, array.length - 1);
        System.out.println(sum);
    }

    public static void mergeSort(int[] arr, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = arr[start];
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(copy, arr, start, mid);
        mergeSort(copy, arr, mid + 1, end);

        int i = mid;
        int j = end;
        int index = end;
        while (i >= start && j > mid) {
            if (arr[i] > arr[j]) {
                copy[index--] = arr[i--];
                sum=sum+j-i;
//                count += j - mid;
            } else {
                copy[index--] = arr[j--];
            }
        }
        for (; i >= start; i--) {
            copy[index--] = arr[i];
        }
        for (; j > mid; j--) {
            copy[index--] = arr[j];
        }
    }

}

