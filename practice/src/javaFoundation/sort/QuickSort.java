package javaFoundation.sort;

/**
 * Created by ChenXiang
 * 从大到小排序
 * 2019/08/19,15:01
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {5, 3, 7, 8, 4, 6};
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void quickSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int low, int high) {
        int i = low, j = high;
        if (low > high) {
            return;
        }
        int index = a[i];
        while (i < j) {
            while (i < j && a[j] <= index) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            while (i < j && a[i] > index) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }

        }
        a[i] = index;
//        sort(a,low,i-1);
//        sort(a,i+1,high);
    }
}
