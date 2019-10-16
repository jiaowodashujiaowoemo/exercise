package LeetCode.最长递增子序列;

import java.util.Arrays;

/**
 * Created by ChenXiang
 * 2019/09/23,13:10
 * 不连续子序列
 * https://segmentfault.com/a/1190000012748540?utm_source=tag-newest
 * <p>
 * 2, 11, 4, 12, 6, 1
 * 为了找到以6结尾的LIS，我们需要先找到以2结尾的LIS和以4结尾的LIS（也就是那些结尾元素比当前元素小且在当前元素左边的LIS）。
 * 从动态规划的角度看，一个较大的父问题被分解为了两个较小的子问题，且父问题和子问题是同一种问题。
 * <p>
 * 整个问题转化为：对于输入序列中的每个元素X，分别找出找出以X结尾的LIS，其中长度最长的，就是我们要找的最终LIS。
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        int maxLen = 1;
        //数组存储了 以nums[i]结尾的LIS的长度，dp[i]dp[j]（其中j比i小），dp[j]在此之前就已经算出来了。
        // 因此，只要按照合适的顺序来求解小问题，我们将大问题分解为小问题的时候就不需要递归，可以直接使用之前的计算结果。
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            //当前扫描到的元素是nums[i]
            for (int j = 0; j < i; j++) {
                //找出在nums[i]左边且比nums[i]小的元素
                if (nums[j] >= nums[i]) {
                    continue;
                }
                //以nums[j]结尾的lis与nums[i]组合，能否产生更长的LIS（以nums[i]结尾）
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    /**
     * 时间复杂度是n^2
     * 外层循环用来诸葛扫描输入，假设当前扫描到的元素是X
     * 内层循环用来找出在X的左边也就是已经扫描过的元素中，值比X小的元素E，使得X能拼接到以E结尾的LIS的后面
     *
     * 如果用二叉树来存储已经扫描过的节点，那么内层查找的时间复杂度能降低为O(logn)。从而整个算法的时间复杂度降低为O(nlogn)。
     */

    /**
     * 动态规划加上二分法也是O(nlogn)
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
     * <p>
     * 解法一中，遍历计算 dp 列表需 O(N)，计算每个dp[k] 需 O(N)
     * 1、动态规划中，通过线性遍历来计算 dp 的复杂度无法降低；
     * 2、每轮计算中，需要通过线性遍历 [0,k) 区间元素来得到 dp[k]。
     * 可以考虑：是否可以通过重新设计状态定义，使整个 dp为一个排序列表；
     * 这样在计算每个 dp[k] 时，就可以通过二分法遍历 [0,k) 区间元素，将此部分复杂度由 O(N) 降至O(logN)。
     * <p>
     * 维护一个列表 tails，其中每个元素 tails[k] 的值代表 长度为 k+1 的子序列尾部元素的值。
     * 如 [1,4,6]序列，长度为 1,2,3 的子序列尾部元素值分别为 tails = [1,4,6]
     *
     *  设 res 为 tails当前长度，代表直到当前的最长上升子序列长度。设 j∈[0,res)，考虑每轮遍历 nums[k] 时，
     *  通过二分法遍历 [0,res) 列表区间，找出 nums[k]的大小分界点，会出现两种情况：
     *
     * 区间中存在 tails[i] > nums[k] ： 将第一个满足 tails[i] > nums[k] 执行 tails[i] = nums[k]；因为更小的 nums[k]后更可能接一个比它大的数字。
     * 区间中不存在 tails[i] > nums[k]： 意味着 nums[k]可以接在前面所有长度的子序列之后，因此肯定是接到最长的后面（长度为 res ），新子序列长度为 res + 1
     *
     *
     * 这个方法还能同时得到最长的序列
     */
    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {  //如果是非严格递增加上等号
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if (res == j) {     //这种情况就是更新的是tails的最后一个值，如果取的nums[i比tails的最后一个值小，就会去前面找正确的位置，这时候tails的长度不会改变，res也就不会变]
                res++;
            }
        }
        return res;
    }
}