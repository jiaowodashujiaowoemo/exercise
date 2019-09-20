package LeetCode.K数之和;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenXiang
 * 2019/09/19,22:48
 */
public class Solution {
    public static ArrayList<List<Integer>> kSum(int[] nums,int target,int k,int start){
        ArrayList<List<Integer>> result=new ArrayList<>();
        if (start>=nums.length){
            return result;
        }
        if (2==k){
            int l=start,h=nums.length-1;
            while (l<h){
                if (nums[l]+nums[h]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[l]);
                    list.add(nums[h]);
                    result.add(list);
                    while (l<h&&nums[l]==nums[l+1]){
                        l++;
                    }
                    while (l<h&&nums[h]==nums[h-1]){
                        h--;
                    }
                    l++;
                    h--;
                }else if (nums[l]+nums[h]<target){
                    l++;
                }else {
                    h--;
                }
            }
            return result;
        }
        if (k>2){
            for (int i=start;i<nums.length;i++){
                ArrayList<List<Integer>> temp=kSum(nums,target-nums[i],k-1,i+1);
                if (temp!=null){
                    for (List<Integer> l:temp){
                        l.add(0,nums[i]);
                    }
                    result.addAll(temp);
                }
                while (i<nums.length-1&&nums[i]==nums[i+1]){
                    i++;
                }
            }
            return result;
        }
        return result;
    }
}
