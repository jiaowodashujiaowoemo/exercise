package 剑指offer.数组中的逆序对;

/**
 * Created by ChenXiang
 * 2019/09/14,21:10
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(InversePairs(new int[]{7,5,6,4}));
    }
    public static int InversePairs(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int[] copy = array.clone();
        int count = mergeSort(array, copy, 0, array.length - 1);
        return count%1000000007;
    }

    public static int mergeSort(int[] arr, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = arr[start];
            return 0;
        }
        int mid = (start + end) / 2;

        int left = mergeSort(copy, arr, start, mid);
        int right = mergeSort(copy, arr, mid + 1, end);

        int count = 0;
        int i = mid;
        int j = end;
        int index = end;
        while (i >= start && j > mid) {
            if (arr[i] > arr[j]) {
                copy[index--] = arr[i--];
                count += j - mid;
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
        return left + right + count;
    }

}
