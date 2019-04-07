package 剑指offer.二维数组查找;

import java.util.concurrent.ExecutorService;

/**
 * @Description
 * @Author ChenXiang
 * @Date 2019/03/17,21:54
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        if (null==array){
            return false;
        }

        int rows= array.length-1;
        int cols=0;

        while (rows>=0&&cols<array[0].length){
            if (array[rows][cols]<target){
                cols++;
            }else if (array[rows][cols]>target){
                rows--;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target=10;
        int[][] arr={
                {1,2,3,4,5},
                {2,3,4,5,6},
                {3,4,5,6,7},
                {4,5,6,7,8},
                {5,6,7,8,9}
        };

        System.out.println(new Solution().Find(target,arr));
    }
}