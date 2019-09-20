package LeetCode.整数翻转;

/**
 * Created by ChenXiang
 * 2019/08/25,22:05
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(1200));
    }

    public static int reverse(int x){
        long y=0;
        while (x!=0){
            y=y*10+x%10;
            x=x/10;
        }
        if (y>Integer.MAX_VALUE||y<Integer.MIN_VALUE){
            return 0;
        }
        return (int) y;
    }
}
