package LeetCode.二叉树左下角的节点;

/**
 * Created by ChenXiang
 * 2019/08/30,11:39
 * 找出二叉树最底层最左边的节点
 * 可以使用深度优先和广度优先
 * 广度优先，用每层的第一个节点更新结果，时间复杂度是O(n)
 * 深度优先，第一次访问一个深度为depth的节点时，x一定是这一层的最左节点，当遇到一个节点的深度大于depth时，用这个节点更新结果
 */
public class Main2 {
    public static void main(String[] args) {

    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int findBottomLeftValue(TreeNode root){
        return  findBottomLeftValue(root,1,new int[]{0,0});
    }

    public int findBottomLeftValue(TreeNode root,int depth,int[] result){
        if (result[1]<depth){
            result[0]=root.val;
            result[1]=depth;
        }
        if (root.left!=null){
            findBottomLeftValue(root.left,depth+1,result);
        }
        if (root.right!=null){
            findBottomLeftValue(root.right,depth+1,result);
        }
        return result[0];
    }
}