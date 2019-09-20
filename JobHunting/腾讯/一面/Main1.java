package 一面;

import com.sun.corba.se.impl.orb.NormalParserData;

/**
 * Created by ChenXiang
 * 2019/09/04,16:52
 * 二叉搜索树第k个节点
 */
public class Main1 {
    public static void main(String[] args) {

    }

    static int index=0;
    public static TreeNode kthNode(TreeNode pRoot,int k){
        if (pRoot==null){
            return null;
        }
        TreeNode node=kthNode(pRoot,k);
        if (node!=null){
            return node;
        }
        index++;
        if (index==k){
            return pRoot;
        }
        node=kthNode(pRoot,k);
        if (node!=null){
            return node;
        }
        return null;
    }
}

class TreeNode{

}
