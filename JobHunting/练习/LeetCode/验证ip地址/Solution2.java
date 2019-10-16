package LeetCode.验证ip地址;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

/**
 * Created by ChenXiang
 * 2019/09/24,16:04
 * 复原ip 93题
 * 找出一串数字所能得到的所有正确的IPv4地址
 */
public class Solution2 {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    public static List<String> restoreIpAddresses(String s) {

        /**
         * 暴力法
         * 不能出现以0开头的两位以上数字

         ArrayList<String> result = new ArrayList<String>();
         int len = s.length();

         for (int i = 0; i < 3 && i < len - 2; i++) {
         for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
         for (int k = j + 1; k < j + 4 && k < len; k++) {
         if (len - k >= 4)      //判断字符串 是否有剩余
         continue;
         int a = Integer.parseInt(s.substring(0, i + 1));
         int b = Integer.parseInt(s.substring(i + 1, j + 1));
         int c = Integer.parseInt(s.substring(j + 1, k + 1));
         int d = Integer.parseInt(s.substring(k + 1));
         if (a > 255 || b > 255 || c > 255 || d > 255)
         continue;
         String ip = a + "." + b + "." + c + "." + d;
         if (ip.length() < len + 3)
         continue;
         result.add(ip);
         }
         }
         }
         return result;
         */

        /**
         * 回溯法
         */
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(String s, int pos, List<String> cur, List<String> res) {
        if (cur.size() >= 4) {
            if (pos == s.length()) {
                res.add(String.join(".", cur));
            }
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (pos + i > s.length()) {
                break;
            }
            String segment = s.substring(pos, pos + i);
            // 剪枝条件：不能以0开头，不能大于255
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }
            cur.add(segment);
            backtrack(s, pos + i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

}
