package 交错正负数;

import java.util.Arrays;

/**
 * Created by ChenXiang
 * 2019/09/22,09:59
 * 含有正数和负数的数组，替换为正负数交替出现的数组，要求常数空间复杂度.不改变原来数组的正数和负数各自的顺序
 * 若正负元素不等，直接把剩下元素放在数组后面：
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -5, -6};
        pnsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 这种方法是保持正数和负数各自顺序不变的，还有一种方法是前后指针，可能会改变顺序
     * 而且这个是让正数在前
     */
    public static void pnsort(int[] arr) {
        int p = 0, n = 0;
        int size = arr.length;
        if (size > 1) {
            while (p < size && n < size) {
                while (arr[p] < 0) {   //p指向第一个正数
                    p++;
                }
                while (arr[n] > 0) {   //n指向第一个负数
                    n++;
                }
                if (p >= size || n >= size) {
                    break;
                }
                while (n - p != 1) {     //如果正负数相邻，下标差为1，不需要交换，不等于1，进行交换
                    if (n > p) {   //负数下标大，直接交换，并让负数下标减1，一直交换到负数和第一个正数相邻
                        int temp = arr[n];
                        arr[n] = arr[n - 1];
                        arr[n - 1] = temp;
                        n--;
                    } else {
                        if (p - n == 1) {    //如果相邻，要同时交换下标和元素
                            int temp = arr[p];
                            arr[p] = arr[p - 1];
                            arr[p - 1] = temp;
                            p--;
                            n++;
                        } else { //如果不相邻，只交换元素，正数下标左移，负数下标不变
                            int temp = arr[p];
                            arr[p] = arr[p - 1];
                            arr[p - 1] = temp;
                            p--;
                        }
                    }
                }
                n = n + 1;
                p = p + 2;  //因为正数在前，负数在后，满足了一对后，要把它们都放到下一个相同的起始位置
            }
        }
    }
}
