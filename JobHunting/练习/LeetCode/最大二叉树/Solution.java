package LeetCode.最大二叉树;

/**
 * Created by ChenXiang
 * 2019/09/07,17:25
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums==null||nums.length==0){
            return null;
        }
        return constructMaximumBinaryTree(nums,0,nums.length);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums,int start,int end){
        if (end-start<=1){
            return new TreeNode((nums[start]));
        }
        int max=start;
        //先遍历一次找最大位置
        for (int i=start;i<end;i++){
            if (nums[i]>nums[max]){
                max=i;
            }
        }
        TreeNode node=new TreeNode(nums[max]);
        //如果最大的数不是最左边位置
        if (max!=start){
            node.left=constructMaximumBinaryTree(nums,start,max);
        }
        //如果最大的数不是最右边的位置
        if (max!=end-1){
            node.right=constructMaximumBinaryTree(nums,max+1,end);
        }
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}