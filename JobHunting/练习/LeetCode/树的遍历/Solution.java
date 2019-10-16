package LeetCode.树的遍历;

import com.sun.org.apache.xpath.internal.operations.Mod;
import oracle.jrockit.jfr.openmbean.RecordingOptionsType;

import java.util.*;

/**
 * Created by ChenXiang
 * 2019/09/07,17:40
 */
public class Solution {
    /**
     *层序遍历（广度优先遍历）
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();//如果使用字符串来保存最后的结果，就不用计算每层的size因为所有层的节点都是放在一起的
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                temp.add(node.val);
                List<Node> child = node.children;
                if (child != null && child.size() > 0) {
                    for (Node n : child) {
                        queue.add(n);
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }

    /**
     * 深度优先打印二叉树
     */

    public List<Integer> preOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        //就是对所有的子树进行遍历，如果只是二叉树，就是分别对左右子树进行递归，n叉树就是对每一个子树进行递归
        for (int i = 0; i < root.children.size(); i++) {
            list.addAll(preOrder(root.children.get(i)));
        }
        return list;
    }

    public List<Integer> preOrderNonRecursive(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node topNode = stack.pop();
            list.add(topNode.val);
            //先序是从后往前压栈，就是二叉树中的先左后右，因为还要弹栈
            for (int i = topNode.children.size() - 1; i >= 0; i--) {
                stack.push(topNode.children.get(i));
            }
        }
        return list;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        for (Node node : root.children) {
            list.addAll(postorder(node));
        }
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderNonRecursive(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node topNode = stack.pop();
            //后序遍历要从前往后压栈
            for (Node node : topNode.children) {
                stack.push(node);
            }
            list.add(0, topNode.val);
        }
        return list;
    }

    /**
     * 二叉树的中序遍历
     */
    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            list.addAll(inorder(root.left));
        }
        list.add(root.val);
        if (root.right!=null){
            list.addAll(inorder(root.right));
        }
        return list;
    }

    public List<Integer> inorderNonRecursive(TreeNode root){
        List<Integer> list=new ArrayList<>();
        if (root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //一直向左走到尽头
            while (root.left!=null){
                root=root.left;
                stack.push(root);
            }
            TreeNode node=stack.pop();
            list.add(node.val);
            //如果栈顶元素有右孩子，将右孩子入栈，进行下一次循环
            if (node.right!=null){
                root=node.right;
                stack.push(root);
            }
        }
        return list;
    }

    /**
     * 从左到右打印从根节点到子节点的所有路径
     */
//    public List<Integer> allSort(TreeNode root){
//
//    }

    /**
     * 之字形打印二叉树
     */
    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        if (pRoot==null){
            return list;
        }
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();

        stack1.push(pRoot);
        while (!stack1.isEmpty()||!stack2.isEmpty()){
            ArrayList<Integer> temp=new ArrayList<>();
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    TreeNode node=stack1.pop();
                    temp.add(node.val);
                    if (node.left!=null){
                        stack2.push(node.left);
                    }
                    if (node.right!=null){
                        stack2.push(node.right);
                    }
                }
            }else {
                while (!stack2.isEmpty()){
                    TreeNode node=stack2.pop();
                    temp.add(node.val);
                    if (node.right!=null){
                        stack1.push(node.right);
                    }
                    if (node.left!=null){
                        stack1.push(node.left);
                    }
                }
            }
            if (temp.size()>0){
                list.add(temp);
            }
        }
        return list;
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

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}