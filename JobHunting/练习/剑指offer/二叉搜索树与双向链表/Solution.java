package 剑指offer.二叉搜索树与双向链表;

/**
 * Created by ChenXiang 要求是不创建任何新节点，所以全程没有对val的操作
 * 2019/07/22,21:36
 */
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode lastNode = null;
        TreeNode headNode = ConvertNode(pRootOfTree, lastNode);
        while (headNode.left != null && headNode != null) {
            headNode = headNode.left;
        }
        return headNode;
    }

    public TreeNode ConvertNode(TreeNode rootTree, TreeNode lastNode) {
        if (null == rootTree) {
            return null;
        }
        if (rootTree.left != null) {
            //这个方法返回的其实是双向链表的尾节点
            lastNode = ConvertNode(rootTree.left, lastNode);
        }
        rootTree.left = lastNode;
        if (lastNode != null) {
            lastNode.right = rootTree;
        }
        lastNode = rootTree;
        if (rootTree.right != null) {
            lastNode = ConvertNode(rootTree.right, lastNode);
        }
        return lastNode;
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
