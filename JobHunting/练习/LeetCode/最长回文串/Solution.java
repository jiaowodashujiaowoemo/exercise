package LeetCode.最长回文串;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ChenXiang
 * 2019/09/20,11:53
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class Solution {
    /**
     * 方法1：int数组
     * 对于每个字母，假设它出现了 v 次。我们可以让 v // 2 * 2 个字母左右对称。
     * 例如，对于字符串 'aaaaa'，其中 'aaaa' 是左右对称，其长度为 5 // 2 * 2 = 4。
     * <p>
     * 最后，如果有任何一个满足 v % 2 == 1 的 v，那么这个字符就可能是回文串中唯一的那个中心。
     * 针对这种情况，我们需要判断 v % 2 == 1 && ans % 2 == 0，后面的判断主要是为了防止重复计算
     */
    public int longestPalindrome1(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[123];//其实使用58个就行，因为从A到z一共只有58个字符
        for (int i = 0; i < chars.length; i++) {
            count[chars[i]]++;
        }
        int result = 0;
        for (int i = 0; i < count.length; i++) {
            //当count中的元素是大于等于2时，result为不大于count[i]的最大偶数
            result += count[i] / 2 + 2;
            //当count[i]为计数且result为偶数时，这个单独出来的字符可以放在中间座位回文的最中间的字符
            if (count[i] % 2 == 1 && result % 2 == 0) {
                result++;
            }
        }
        return result;


    }

    /**
     * 方法2：Map计数
     */
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        int result = 0;
        for (int count : map.values()) {
            result += count / 2 * 2;
            if (count % 2 == 1 && result % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}
