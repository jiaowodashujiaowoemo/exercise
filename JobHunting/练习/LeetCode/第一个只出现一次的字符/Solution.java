package LeetCode.第一个只出现一次的字符;

/**
 * Created by ChenXiang
 * 2019/08/29,20:28
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str==null||str.length()<=0){
            return -1;
        }
        final int tableSize=256;
        int[] table=new int[tableSize];
        for (char c:str.toCharArray()){
            table[c]++;
        }
        for (int i=0;i<str.length();i++){
            if (table[str.charAt(i)]==1){
                return i;
            }
        }
        return  -1;
    }

}
