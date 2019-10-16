package LeetCode.二叉树最大宽度;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenXiang
 * 2019/09/25,11:25
 * 二叉树的宽度，是所有层的最大宽度,二叉树是满二叉树的结构
 * 层的最大宽度包含中间的空节点
 * <p>
 * 如果采取二叉树的层次遍历，用空节点来占据每层中首尾非空节点中间的空位置来计算每层最大宽度,容易发生超时，因为第n次有2^(n-1)个节点，增长速度极快
 * <p>
 * 因此根据在一颗二叉树中,左孩子在其所在层次中的下标为其父节点的下标*2，右孩子在其所在层次中的下标等于其父节点的下标*2+1 的规律（下标值从0开始)。
 * 构造（TreeNode, index）的二元组来记录每个非空节点的位置，便可在层次遍历时只向队列中加入非空节点来缩短遍历所需要的时间。
 */
public class Solution {
    private int maxWidth=0;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root,1,1,new ArrayList<>());
        return maxWidth;
    }


    /**
     * https://blog.csdn.net/qq_39241239/article/details/86695710
     * 假设满二叉树表示成数组序列, 根节点所在的位置为1,
     * 则任意位于i节点的左右子节点的index为2*i, 2*i+1。
     * 用一个List保存每层的左端点,易知二叉树有多少层List的元素就有多少个。
     * 那么可以在dfs的过程中记录每个节点的index及其所在的层level,
     * 如果level>List.size()说明当前节点就是新的一层的最左节点, 将其 加入List中,
     * 否则判断当前节点的index减去List中对应层的最左节点的index的宽度是否大于最大宽度并更新
     **/
    private void dfs(TreeNode root, int level, int index, List<Integer> list){
        if (root==null){
            return;
        }
        if (level>list.size()){
            list.add(index);
        }
        maxWidth=Math.max(maxWidth,index-list.get(level-1)+1);
        //遍历左子树
        dfs(root.left,level+1,index*2,list);
        //遍历右子树
        dfs(root.right,level+1,index*2+1,list);
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
