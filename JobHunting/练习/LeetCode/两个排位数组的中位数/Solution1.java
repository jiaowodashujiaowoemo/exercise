package LeetCode.两个排位数组的中位数;

import java.util.Arrays;

/**
 * Created by ChenXiang
 * 2019/09/04,22:07
 * https://www.nowcoder.com/discuss/196951?type=0&order=0&pos=29&page=0
 * 寻找中位数，本质为寻找第k小的数，假设数组的长度是m，找第(m+1)/2位和第(m+2)/2位的元素，两者的平均数即为数组的中位数。
 * 如果数组a的中位数小于数组b的中位数，那么整体的中位数只可能出现在a的右区间加上b的左区间之中；
 * 如果数组a的中位数大于等于数组b的中位数，那么整体的中位数只可能出现在a的左区间加上b的右区间之中。
 * 关键就是利用分治的思想逐渐缩小a的区间和b的区间来找到中位数。
 * <p>
 * 对于不等长的数组，原理是一样的，因为如果我们去掉数组比中位数小的k个数，再去掉比中位数大的k个数，得到的子数组的中位数和原来的中位数相同。
 */
public class Solution1 {
    /**
     * 先分析一个有序数组的中位数，当有序数组的个数为奇数时，如nums=[1, 2, 3, 4, 5]，该数组的中位数为nums[2]=3；
     * 当有序数组的个数为偶数时，如nums=[1, 2, 3, 4, 5, 6]，该数组的中位数为(nums[2]+nums[3])/2=3.5
     */
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null || nums1.length == 0 && nums2.length == 0) return 0.0;
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    //在两个有序数组中二分查找第k大元素
    public int getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        /**
         * O(lg(m+n))
         * 当某个数组查找的起始位置大于等于该数组长度时，说明这个数组中的所有数已经被淘汰，则只需要在另一个数组找查找即可
         */
        if (start1 > nums1.length-1) {
            return nums2[start2 + k - 1];
        }
        if (start2 > nums2.length-1) {
            return nums1[start1 + k - 1];
        }

        /**
         * 如果k=1时，即需要查找第一个数，则找到两个数组起始位置中最小的那个即可
         * 为什么是小的那个？
         * 因为两个都是有序数组
         */
        if (1 == k) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        //分别在两个数组中查找第k/2个元素，若存在（即数组没有越界），标记为找到的值；若不存在，标记为整数最大值
        int mid1 = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}
//https://blog.csdn.net/qiki_tangmingwei/article/details/79686862