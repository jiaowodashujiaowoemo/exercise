package LeetCode.N皇后;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by ChenXiang
 * 2019/09/20,16:01
 * 只求解决方案的数量，不用记录具体的解决方案
 */
public class Solution2 {
    private Set<Integer> col;
    private Set<Integer> master;    //主对角线
    private Set<Integer> slave;     //副对角线
    private int n;
    private int result;

    public int totalNQueens(int n) {
        this.n=n;
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
            result++;
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
    //很牛逼的方法但是没看懂
//    /**
//     * 核心思路
//     * 使用常规深度优先一层层搜索
//     * 使用三个整形分别标记每一层哪些格子可以放置皇后，这三个整形分别代表列、左斜下、右斜下（_col, ld, rd_），
//     * 二进制位为 1 代表不能放置，0代表可以放置
//     * 核心两个位运算：
//     * x & -x 代表除最后一位 1 保留，其它位全部为 0
//     * x & (x - 1) 代表将最后一位 1 变成 0
//     */
//    private int result;
//    public int totalQueens(int n){
//        dfs(n,0,0,0,0);
//        return result;
//    }
//
//    private void dfs(int n, int row, int col, int ld, int rd) {
//        if (row>=n){
//            result++;
//            return;
//        }
//        //将所有能放Q的位置由0变成1，以便进行后续的遍历
//        int bits=~(col|ld|rd)&((1<<n)-1);
//        while (bits>0){
//            int pick = bits & -bits; // 注: x & -x
//            dfs(n, row + 1, col | pick, (ld | pick) << 1, (rd | pick) >> 1);
//            bits &= bits - 1; // 注: x & (x - 1)
//        }
//    }
}
