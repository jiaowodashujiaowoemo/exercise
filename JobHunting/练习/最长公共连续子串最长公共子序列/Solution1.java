package 最长公共连续子串最长公共子序列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.DoublePredicate;

/**
 * Created by ChenXiang
 * 2019/09/18,15:45
 * 最长公共子序列
 * https://blog.csdn.net/cyblueboy83/article/details/80310384
 */
public class Solution1 {
    static int[][] dp;

    public static int LCS(String string1, String string2) {
        int len1 = string1.length();
        int len2 = string2.length();
        dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (string1.charAt(i-1) == string2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    static Set<String> allLcs = new HashSet<>();

    public static void printAllLcs(String string1, String string2, String lcsStr) {
        int i = string1.length();
        int j = string2.length();
        while (i > 0 && j > 0) {
            if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                lcsStr = string1.charAt(i - 1) + lcsStr;  //逆向存放
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) { //向左走
                    --i;
                } else if (dp[i - 1][j] < dp[i][j - 1]) {   //向上走
                    --j;
                } else { //向上向左都是LCS的元素
                    printAllLcs(string1.substring(0, i - 1), string2, lcsStr);
                    printAllLcs(string1, string2.substring(0, j - 1), lcsStr);
                    return;
                }
            }
        }
        allLcs.add(lcsStr);
    }

    public static void main(String[] args) {
        String string1 = "123ABCD4567";
        String string2 = "ABE12345D6";
        System.out.println(LCS(string1, string2));
        String lcsStr = "";
        printAllLcs(string1, string2, lcsStr);
        Iterator iterator = allLcs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
