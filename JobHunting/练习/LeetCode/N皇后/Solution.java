package LeetCode.N皇后;

import java.util.*;

/**
 * Created by ChenXiang
 * 2019/09/17,18:46
 * 任意两个皇后都不能处于同一行、同一列或同一斜线上
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位
 *
 * 主对角线(上升线)上元素的横纵坐标之和是固定的
 * 副对角线（下降线）上元素的横纵坐标之差是固定的
 */
public class Solution {
    private Set<Integer> col;
    private Set<Integer> master;    //主对角线
    private Set<Integer> slave;     //副对角线
    private int n;
    private List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        result=new ArrayList<>();
        if (n==0){
            return result;
        }
        col=new HashSet<>();
        master=new HashSet<>();
        slave=new HashSet<>();

        Stack<Integer> stack=new Stack<>();
        backTrack(0,stack);
        return result;
    }

    private void backTrack(int row, Stack<Integer> stack) {
        if(row==n){
            List<String> board=covert2Board(stack,n);
            result.add(board);
            return;
        }
        //针对每一列尝试是否可以放置
        for (int i=0;i<n;i++){
            if (!col.contains(i)&&!master.contains(row+i)&&!slave.contains(row-i)){
                stack.add(i);
                col.add(i);
                master.add(row+i);
                slave.add(row-i);

                backTrack(row+1,stack);

                slave.remove(row-i);
                master.remove(row+i);
                col.remove(i);
                stack.pop();
            }
        }
    }

    private List<String> covert2Board(Stack<Integer> stack, int n) {
        List<String> board=new ArrayList<>();
        for (Integer num:stack){
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<n;i++){
                sb.append(".");
            }
            sb.replace(num,num+1,"Q");
            board.add(sb.toString());
        }
        return board;
    }
}
