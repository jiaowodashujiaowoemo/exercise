package LeetCode.宝石与石头;

/**
 * Created by ChenXiang
 * 2019/08/25,22:24
 * ascii表中字母的范围是65-122
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J==null||J.length()==0||S==null||S.length()==0){
            return 0;
        }
        byte[] arr=new byte[58];
        int count=0;
        for (char ch:J.toCharArray()){
            arr[ch-65]=1;
        }
        for (char ch:S.toCharArray()){
            if (arr[ch-65]==1){
                count++;
            }
        }
        return count;
    }
}
