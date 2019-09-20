package 最长公共连续子串最长公共子序列;

/**
 * Created by ChenXiang
 * 2019/09/18,15:45
 * 最长公共连续子串
 * https://blog.csdn.net/ten_sory/article/details/79857531（打印所有公共子串）
 * https://blog.csdn.net/cyblueboy83/article/details/80310384
 * 和最长子序列不同的是在这种情况下，如果某两个字符不相等，需要将dp数组中该位置为0，而在子序列中不用
 * 动态规划
 * 状态转移方程如下：
 * 若i=0或j=0，则dp[i][j] = 0
 * 否则：
 * 		若A[i]==B[j]，则dp[i][j] = dp[i-1][j-1] + 1
 * 		若A[i]!=B[j]，则dp[i][j] = 0
 */
public class Solution2 {
    public int LCS(String string1,String string2){
        int len1=string1.length();
        int len2=string2.length();
        int[][] dp=new int[len1+1][len2+1];
        int maxLen=0;
        for (int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                if (string1.charAt(i-1)==string2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    maxLen=Math.max(dp[i][j],maxLen);
                }else {
                    /**
                     * 最长子串和最长子序列的区别仅仅在这种情况的处理
                     */
                    dp[i][j]=0;
                }
            }
        }
        return maxLen;
    }


}
