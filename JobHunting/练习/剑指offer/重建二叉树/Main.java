package 剑指offer.重建二叉树;

import java.util.Arrays;

/**
 * Created by ChenXiang
 * 2019/09/14,22:09
 * 根据前序遍历和中序遍历的结果重建二叉树
 */
public class Main {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre==null||in==null){
            return null;
        }
        //遍历长度不一样，书肯定不存在
        if (pre.length!=in.length){
            return null;
        }
        return construct(pre,in);
    }
    public TreeNode construct(int[] pre,int[] in){
        //长度为0时返回null
        if (pre==null||in==null||pre.length==0||in.length==0){
            return null;
        }
        TreeNode root=new TreeNode(pre[0]);
        for (int i=0;i<in.length;i++){
            if (in[i]==pre[0]){
                root.left=construct(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right=construct(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
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
