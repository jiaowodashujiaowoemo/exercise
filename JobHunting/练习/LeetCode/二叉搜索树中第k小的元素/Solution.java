package LeetCode.二叉搜索树中第k小的元素;

import java.util.Stack;

/**
 * Created by ChenXiang
 * 2019/09/25,09:53
 *
 * 二叉搜索树按中序遍历，得到有序数组
 */
public class Solution {
    /**
     * 递归
     */
    int k=0;
    int result=0;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        helper(root);
        return result;
    }

    public void helper(TreeNode root){
        if (root.left!=null){
            helper(root.left);
        }
        k--;
        if (k==0){
            result=root.val;
            return;
        }
        if (root.right!=null){
            helper(root.right);
        }
    }

    /**
     * 迭代
     */
    public static int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            while (root.left!=null){
                root=root.left;
                stack.push(root);
            }
            TreeNode node=stack.pop();
            k--;
            if (k==0){
                return node.val;
            }
            if (node.right!=null){
                root=node.right;
                stack.push(root);
            }
        }
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node2.left=node1;
        node2.right=node3;
        System.out.println(kthSmallest1(node2,3));
    }
}

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
