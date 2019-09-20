package 剑指offer.字符串的排列;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ChenXiang
 * 2019/07/25,16:50
 */
public class Solution {
    ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(new Solution().permutation("123"));
    }

    public ArrayList<String> permutation(String str) {
        if (str == null || str == "") {
            return list;
        }
        permutation(str.toCharArray(), 0);
        Collections.sort(list);
        return list;
    }

    public void permutation(char[] str, int start) {
        //返回条件
        if (start == str.length) {
            if (!list.contains(new String(str))) {
                list.add(new String(str));
            }
            return;
        }
        for (int i = start; i < str.length; i++) {
            char temp = str[i];
            str[i] = str[start];
            str[start] = temp;
            permutation(str, start + 1);
            char temp1 = str[i];
            str[i] = str[start];
            str[start] = temp1;
        }

    }
}
