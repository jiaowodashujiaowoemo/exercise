package LeetCode.二叉树的直径;

/**
 * Created by ChenXiang
 * 2019/09/16,14:45
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点
 *
 * 一个节点的最大直径=左子树的高度+右子树的高度
 * 遍历每个节点，找出所有节点中的直径的最大值
 */
public class Solution {
    public static void main(String[] args) {

    }

    //max用于记录最大直径
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftDepth=depth(root.left);
        int rightDepth=depth(root.right);
        //记录最大直径
        max=Math.max(max,leftDepth+rightDepth);
        //计算的直径是左子树高度+右子树高度，这里返回当前树的高度，加上1表示子树到当前节点的哪条路径
        return Math.max(leftDepth,rightDepth)+1;
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
