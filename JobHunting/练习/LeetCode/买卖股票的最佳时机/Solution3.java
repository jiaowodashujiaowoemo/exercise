package LeetCode.买卖股票的最佳时机;

/**
 * Created by ChenXiang
 * 2019/09/23,15:11
 * <p>
 * 最多可以进行两笔交易，不能同时参与多笔交易
 * 两种方法：
 * 动态规划
 * 状态机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--29/
 */
public class Solution3 {
    /**
     * 动态规划
     * dp[i][k] 表示前i天最多交易k次的最高收益
     * 首先第 i 天可以什么都不操作，今天的最高收益就等于昨天的最高收益 dp[i][k] = dp[i-1][k]
     * 为了获得更大收益我们第 i 天也可以选择卖出，既然选择卖出，那么在0到 i-1 天就要选择一天买入。多选择了一次买入，那在买入之前已经进行了 k-1 次买卖
     * 在第 0 天买入，收益就是 prices[i] - prices[0]
     * 在第 1 天买入，收益就是 prices[i] - prices[1] + dp[0][k-1]，多加了前一天的最大收益
     * 在第 2 天买入，收益就是 prices[i] - prices[2] + dp[1][k-1]，多加了前一天的最大收益
     * 在第 j 天买入，收益就是 prices[i] - prices[j] + dp[j-1][k-1]，多加了前一天的最大收益
     *
     * 为了获得更大收益我们第 i 天也可以选择卖出，既然选择卖出，那么在0到 i-1 天就要选择一天买入。
     * 我们也可以选择0到i天中选择一天买入，因为第 i 天买入，第 i天卖出对最后的收益是没有影响的。
     * dp[i][k] = Max(dp[i-1][k],prices[i] - prices[j] + dp[j][k-1])，j 取 0 - i
     * prices[i] - prices[j] + dp[j][k-1] 也可以看做， prices[i] - (prices[j] - dp[j][k-1])
     * 为了求这个表达式的最大值，我们可以找prices[j] - dp[j][k-1]的最小值
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
//        int K = 2;
//        int[][] dp = new int[prices.length][K + 1];
//        for (int k = 1; k <= K; k++) {
//            for (int i = 1; i < prices.length; i++) {
//                int min = Integer.MAX_VALUE;
//                //找出第 0 天到第 i 天 prices[buy] - dp[buy][k - 1] 的最小值
//                for (int buy = 0; buy <= i; buy++) {
//                    min = Math.min(prices[buy] - dp[buy][k - 1], min);
//                }
//                //比较不操作和选择一天买入的哪个值更大
//                dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min);
//            }
//        }
//        return dp[prices.length - 1][K];
        /**
         * 找第 j 天prices[buy] - dp[buy][k - 1] 的最小值的时候
         * 我们考虑了 prices[0] - dp[0][k - 1] 、 prices[1] - dp[1][k - 1] 、 prices[2] - dp[2][k - 1] ...，
         * 找第 j + 1 天prices[buy] - dp[buy][k - 1] 的最小值的时候，
         * 我们又会从头考虑 prices[0] - dp[0][k - 1] 、 prices[1] - dp[1][k - 1] 、 prices[2] - dp[2][k - 1] ...，
         * 所以其实没必要每次从头考虑，我们只需要把之前的结果保存起来，然后再和新加入的 prices[j+1] - dp[j+1][k - 1] 比较就可以了
         */
//        int K = 2;
//        int[][] dp = new int[prices.length][K + 1];
//        for (int k = 1; k <= K; k++) {
//            int min = prices[0];
//            for (int i = 1; i < prices.length; i++) {
//                //找出第 1 天到第 i 天 prices[buy] - dp[buy][k - 1] 的最小值
//                min = Math.min(prices[i] - dp[i][k - 1], min);
//                //比较不操作和选择一天买入的哪个值更大
//                dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min);
//            }
//        }
//        return dp[prices.length - 1][K];

        /**
         * 根据代码，我们是固定 k 然后一列一列更新 dp。而更新当前列只需要前一列的信息，所以不需要二维数组
         * 只需要一个一维数组。但是注意到最外层的 for 循环是一个常数次，所以我们可以把两层循环内外颠倒下，可以更好的进行空间复杂度的优化。
         */
//        int K = 2;
//        int[][] dp = new int[prices.length][K + 1];
//        int min[] = new int[K + 1];
//        for (int i = 1; i <= K; i++) {
//            min[i] = prices[0];
//        }
//        for (int i = 1; i < prices.length; i++) {
//            for (int k = 1; k <= K; k++) {
//                min[k] = Math.min(prices[i] - dp[i][k - 1], min[k]);
//                dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min[k]);
//            }
//        }
//        return dp[prices.length - 1][K];

        /**
         * 由于 K 是一个常数，所以我们的 min 数组和 dp 数组都可以分别当成两个变量
         */
        int dp1 = 0;
        int dp2 = 0;
        int min1 = prices[0];
        int min2 = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min1 = Math.min(prices[i] - 0, min1);
            dp1 = Math.max(dp1, prices[i] - min1);

            min2 = Math.min(prices[i] - dp1, min2);
            dp2 = Math.max(dp2, prices[i] - min2);
        }
        return dp2;
    }

    /**
     * 状态机
     * 每天我们其实是有四个状态，买入当前价格的股票，以当前价格的股票卖出。第二次买入股票，第二次卖出股票。
     * s0代表初始状态，初始时钱是 0。
     * s1代表第一次买入后当前的钱，s2代表第一次卖出后当前的前，s3代表第二次买入后当前的钱，s4代表第二次卖出后当前的钱。
     * 然后只需更新每天的四个状态即可
     */
    public int maxProfit2(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }
        int s1 = -prices[0], s2 = Integer.MIN_VALUE, s3 = Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;
        for (int i=1;i<prices.length;i++){
            s1=Math.max(s1,-prices[i]);
            s2=Math.max(s2,s1+prices[i]);
            s3=Math.max(s3,s2-prices[i]);
            s4=Math.max(s4,s3+prices[i]);
        }
        return Math.max(0,s4);
    }
}
