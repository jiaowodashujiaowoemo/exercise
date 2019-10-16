package LeetCode.最长递增子序列;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by ChenXiang
 * 2019/09/23,13:10
 * 连续子序列
 */
public class Solution1 {

    /**
     * 这个方法是把最长的序列也保存起来了
     */
    public static List<Integer> findLengthOfLCIS(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) {
                temp.add(nums[i]);
            }
            if (temp.size() > result.size()) {
                result.clear();
                result.addAll(temp);
            }
            if (nums[i] < nums[i - 1]) {
                temp.clear();
                temp.add(nums[i]);
            }

        }
        return result;
    }

    /**
     * 这个方法只求出最长序列的长度
     */
    public static int findLengthOfLCIS1(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int result=1;
        int temp=1;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i+1]>nums[i]){
                temp++;
            }else {
                temp=1;
            }
            result=Math.max(result,temp);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println((findLengthOfLCIS(new int[]{1, 3, 5, 4, 7, 8, 9, 6, 7})));
    }
}
