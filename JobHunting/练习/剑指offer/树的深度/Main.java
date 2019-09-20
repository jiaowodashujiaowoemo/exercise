package 剑指offer.树的深度;

import sun.reflect.generics.tree.Tree;

/**
 * Created by ChenXiang
 * 2019/09/14,21:39
 */
public class Main {
    public int TreeDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left= TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return Math.max(left,right)+1;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
