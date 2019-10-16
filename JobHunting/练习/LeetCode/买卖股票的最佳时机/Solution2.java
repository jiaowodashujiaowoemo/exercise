package LeetCode.买卖股票的最佳时机;

/**
 * Created by ChenXiang
 * 2019/09/23,14:53
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0){
            return 0;
        }
        int length=prices.length;
        int max=0;
        for (int i=1;i<length;i++){
            if (prices[i]>prices[i-1]){
                max=max+prices[i]-prices[i-1];
            }
        }
        return max;
    }
}
