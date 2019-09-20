package LeetCode.三个数的最大乘积;

import java.util.Arrays;

/**
 * Created by ChenXiang
 * 2019/09/10,14:51
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积
 * 只有两种情况：全是正数和两负数一正数
 * 所以，排序
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }
}
