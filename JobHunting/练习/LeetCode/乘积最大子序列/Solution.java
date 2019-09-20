package LeetCode.乘积最大子序列;

/**
 * Created by ChenXiang
 * 2019/09/09,22:27
 * <p>
 * 本题是求最大乘积，是最大子段和的变种。最大乘积可以由正数*正数和负数*负数得到，因此，需要同时记录下最大值和最小值。
 * <p>
 * 状态转移方程：
 * <p>
 * dp[i] = max(maxm*nums[i],minm*nums[i],dp[i-1])
 * <p>
 * maxm = max(maxm*nums[i],minm*nums[i],nums[i])
 * <p>
 * minm = min(maxm*nums[i],minm*nums[i],nums[i])
 * <p>
 * 其中，dp[i]表示前i个数中的最大乘积，maxm表示以第i-1个字符结尾的最大乘积,minm表示以第i-1个字符结尾的最小乘积,nums[i]即为第i个数。
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int max, min, res;
        max = min = res = nums[0];
        /**
         * 本题的解题思路是同时记录当前最大值和最小值ma, mi：
         * 当nums[i]是正数时，ma仍然是最大值，mi * nums[i]为最小值；
         * 当nums[i]是负数时，ma将变成最小值，mi * nums[i]为最大值；
         * 因此，当nums[i] < 0时，我们交换ma, mi。
         * 在遍历nums过程中，每次更新res获取全局最大值。
         */
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
