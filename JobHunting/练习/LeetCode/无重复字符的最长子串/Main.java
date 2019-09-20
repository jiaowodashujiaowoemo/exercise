package LeetCode.无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChenXiang
 * 2019/09/12,19:56
 */
public class Main {
    public int lengthOfLongestSubstring(String s){
        int n=s.length(),result=0;
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0,j=0;j<n;j++){
            if (map.containsKey(s.charAt(j))){
                i=Math.max(map.get(s.charAt(j)),i);
            }
            result=Math.max(result,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return result;
    }
}
