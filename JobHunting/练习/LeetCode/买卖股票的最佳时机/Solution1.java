package LeetCode.买卖股票的最佳时机;

/**
 * Created by ChenXiang
 * 2019/09/23,14:39
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0){
            return 0;
        }
        int length=prices.length;
        int max=0,min=prices[0];
        for (int i=1;i<length;i++){
            min=Math.min(prices[i],min);
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }
}
