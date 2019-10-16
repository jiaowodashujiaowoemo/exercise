package LeetCode.零钱兑换;

import java.text.DateFormat;
import java.util.Arrays;

/**
 * Created by ChenXiang
 * 2019/09/23,16:54
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1
 * <p>
 * https://blog.csdn.net/zw159357/article/details/82664026
 * f(n)=
 * 0，当n=0
 * 1+min(f(n-ci))  ci为第i个硬币的面值
 */
public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    /**
                     * 利用11来凑出15，付出的代价等于f(4)加上自己这一张钞票
                     * 加1的意思是这样
                     */
                    dp[i] = Math.min(dp[i], dp[i - coin]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
