package LeetCode.数组中的逆序对;

/**
 * Created by ChenXiang
 * 2019/08/29,21:11
 */
public class Solution {
    public static int InversePairs(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int[] copy = array.clone();
        int count = mergeSort(array, copy, 0, array.length - 1);
        return count;
    }

    public static int mergeSort(int[] arr, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = arr[start];
            return 0;
        }
        int mid = (start + end) / 2;
        /**
         * 在归并时，需要array的左右子数组是已经排好序的数组，归并的结果是得到排好序的数组copy
         * 因此在递归调用时，方法前两个参数需要换位置，第一次用copy当辅助数组对array排序，第二次就反过来
         */
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
