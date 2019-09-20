package LeetCode.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenXiang
 * 2019/09/19,22:46
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 四元组不能重复
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums=new int[]{0,0,1,1};
        int target=2;
        List<List<Integer>> list=fourSum(nums,target);
        System.out.println(list);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //优化，若连续的四数之和大于target，后面的肯定都不符合
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                //去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) {
                    continue;
                }
                int start = j + 1;
                int end = len - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        while (start<end&&nums[start]==nums[++start]);
                        while (start<end&&nums[end]==nums[--end]);
                    }
                    else if (sum<target){
                        while (start<end&&nums[start]==nums[++start]);
                    }else {
                        while (start<end&&nums[end]==nums[--end]);
                    }
                }
            }
        }
        return result;
    }
}
