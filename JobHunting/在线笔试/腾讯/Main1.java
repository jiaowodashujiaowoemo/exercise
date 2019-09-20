package 腾讯;

/**
 * Created by ChenXiang
 * 2019/08/17,19:59
 * 字符串压缩
 */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入的压缩后的字符串
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        //将压缩后的字符串转为字符数组
        char[] chars = str.toCharArray();
        //用于保存字符串重复的次数
        int count = 0;
        int level = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            char onechar = chars[i];
            if ((onechar + "").matches("[A-Z]")) {
                if (level == 0) {
                    sb.append(onechar);
                } else {
                    tmp.append(onechar);
                }
            } else if ((onechar + "").equals("]")) {
                level++;
            } else if ((onechar + "").equals("|")) {
                if ((chars[i - 1] + "").matches("[0-9]")) {
                    count = Integer.parseInt((chars[i - 1] + ""));
                } else {
                    count = 1;
                }
                for (int j = 0; j < count; j++) {
                    stringBuilder.append(tmp);
                }
                i--;
            } else if ((onechar + "").equals("[")) {
                if (level == 1) {
                    sb.append(stringBuilder);
                }
                tmp.setLength(0);
                tmp.append(stringBuilder.toString());
                stringBuilder.setLength(0);
                level--;
            }
        }
        sb.append(stringBuilder);
        System.out.println(sb.reverse().toString());
    }
//   ConcurrentHashMap

}
//HG[3|B[2|CA]]F
