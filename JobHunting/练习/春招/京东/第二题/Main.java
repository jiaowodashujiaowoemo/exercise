package 春招.京东.第二题;
import java.util.Scanner;
/**
 * @Description 给出m个字符串S1,S2,...,Sm和一个单独的字符串T，在T中选出尽可能多的子串同时满足：
 *              1、这些子串在T中互不相交
 *              2、这些子串都是S1,S2,...,Sm中的某个串
 *              求最多能选出多少个子串
 *              第一行输入m，然后m行输入子串，最后输入T，串中只会出现小写字母，单个串长度不超过100000
 * @Author ChenXiang
 * @Date 2019/04/14,22:12
 */

/**
 * 样例：3
 *      aa
 *      b
 *      ac
 *      bbaac
 * 输出：3
 */

/**
 * 只过了73
 */
public class Main {

    /**
     * 求出一个字符数组的next数组
     * @param t 字符数组
     * <a href="/profile/547241" data-card-uid="547241" class="js-nc-card" target="_blank" style="color: #25bb9b">@return next数组
     */
    public static int[] getNextArray(char[] t) {
        int[] next = new int[t.length+1];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k=next[j-1];
            while (k!=-1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                }
                else {
                    k = next[k];
                }
                next[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
            }
        }
        return next;
    }

    /**
     * 对主串s和模式串t进行KMP模式匹配
     * @param s 主串
     * @param t 模式串
     * </a><a href="/profile/547241" data-card-uid="547241" class="js-nc-card" target="_blank" style="color: #25bb9b">@return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    public static int kmpMatch(String s, String t){
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] next = getNextArray(t_arr);
        int i = 0, j = 0;
        while (i<s_arr.length && j<t_arr.length){
            if(j == -1 || s_arr[i]==t_arr[j]){
                i++;
                j++;
            }
            else
                j = next[j];
        }
        if(j == t_arr.length)
            return i-j;
        else
            return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = Integer.valueOf(in.nextLine());
        String[] strings = new String[m];
        for(int i=0;i<m;i++){
            strings[i]=in.nextLine();
        }
        String t = in.nextLine();
        int count = 0;
        for(int i=0;i<m;i++){
            int matchIndex = kmpMatch(t,strings[i]);
            while (matchIndex>=0){
                StringBuilder stringBuilder = new StringBuilder(t.substring(0,matchIndex));
                int le = strings[i].length();
                while (le>0){
                    stringBuilder.append('1');
                    le--;
                }
                stringBuilder.append(t.substring(matchIndex+strings[i].length(),t.length()));
                t = stringBuilder.toString();
                count++;
                matchIndex = kmpMatch(t,strings[i]);
            }

        }
        System.out.println(count);
    }
}