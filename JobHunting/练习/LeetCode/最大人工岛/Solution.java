package LeetCode.最大人工岛;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by ChenXiang
 * 2019/09/20,16:16
 * 在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
 * <p>
 * 进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）
 */
public class Solution {
    private int[][] grid;
    private int[][] visited;    //记录每一块陆地的id
    private int R, C;
    private int cccount;    //记录联通分量个数
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] arr = {{1, 0}, {0, 1}};
        System.out.println(new Solution().largestIsland(arr));
    }

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        visited = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visited[i][j] = -1;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j] == -1 && grid[i][j] == 1) {
                    dfs(i, j);
                    cccount++;  //联通分量数量
                }
            }
        }
        if (cccount == 0) {
            //图中全是海，不管怎么填，最大都只能是1
            return 1;
        }
        Integer[] area = new Integer[cccount];    //记录各个联通分量面积大小
        for (int i = 0; i < cccount; i++) {
            area[i] = 0;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j] != -1) {
                    area[visited[i][j]]++;  //给这个方格所在的的联通分量的数量加1
                }
            }
        }

        int maxArea = Collections.max(Arrays.asList(area));  //不能直接加1，因为可能全部都是陆地
        /**
         * 如果矩阵中有0，也就是说不全是陆地，诶最大值加1再进行后面的运算
         * 但是把这一段去掉也是正确的
         * 还没搞懂为什么要加上这个，对时间和空间都都没有任何提升
         */
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                if (visited[i][j] == -1) {  //如果矩阵中有0的话，给最大值加1
//                    maxArea++;
//                    break;
//                }
//            }
//            break;
//        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j] == -1) {
                    int curArea = 1;
                    //必须保证（i，j）相邻节点不是同一个联通分量的节点才能够相加
                    boolean[] flag = new boolean[cccount]; //通过flag数组记录某个联通分量是否已经被加过
                    for (int k = 0; k < 4; k++) {
                        int netx = i + dirs[k][0], nety = j + dirs[k][1];
                        if (inArea(netx, nety) && visited[netx][nety] != -1 && !flag[visited[netx][nety]]) {
                            curArea += area[visited[netx][nety]];
                            flag[visited[netx][nety]] = true;
                        }
                    }
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int x, int y) {
        visited[x][y] = cccount;  //所有联通的陆地的编号是相同的
        for (int m = 0; m < 4; m++) {  //判断给翻个四周，如果旁边的方格还没有被访问过，且这一块是陆地，而且这个方格在范围内，因为边上的方格旁边是超出范围的
            int netx = x + dirs[m][0], nety = y + dirs[m][1];
            if (inArea(netx, nety) && visited[netx][nety] == -1 && grid[netx][nety] == 1) {
                dfs(netx, nety);
            }
        }
    }

    private boolean inArea(int netx, int nety) {
        return netx >= 0 && netx < R && nety >= 0 && nety < C;
    }
}
