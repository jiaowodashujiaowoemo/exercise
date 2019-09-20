package 字符压缩算法;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChenXiang
 * 在单层括号时可以，多层括号报错,需要根据扩进行递归，内层括号的输出为外层括号的输入
 * 腾讯的第一题跟这个有点像，过了
 * 2019/08/03,19:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //行数
        int n = scanner.nextInt();
        //输入的压缩后的字符串
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.next();
        }
        //用来保存中间结果的变量
        String[] sb = new String[n];
        for (int k = 0; k < n; k++) {
            sb[k] = "";
        }

        //依次处理输入的字符串
        for (int i = 0; i < n; i++) {
            if (!hasDigit(strs[i])) {
                sb[i] = strs[i];
                continue;
            }
            //把字符串转成字符数组
            char[] chars = strs[i].toCharArray();
            int count = 0;
            String temp = "";
            for (int m = 0; m < chars.length; m++) {
                if ((chars[m] + "").matches("[(]")) {
                    //如果最后字符要加的话，就m++，不要的话就++m
                    while (!(chars[++m] + "").matches("[)]")) {
                        temp += String.valueOf(chars[m]);
                    }
//                    temp=temp.substring(0,temp.length()-1);
                } else if ((chars[m] + "").matches("[A-Z]")) {
                    temp += chars[m] + "";
                } else if (Character.isDigit(chars[m])) {
                    count = Integer.parseInt(chars[m] + "");
                    for (int l = 0; l < count; l++) {
                        sb[i] += temp;
                    }
                    temp = "";
                }
            }
            sb[i] += temp;
        }
        System.out.println(sb[0]);
    }


    //判断字符串中是否含有数字,true表示有数字
    public static boolean hasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }


}
