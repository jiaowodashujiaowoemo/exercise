package LeetCode.大数运算;

import java.util.Arrays;

/**
 * Created by ChenXiang
 * 2019/09/12,15:38
 * 字符串相加，就是大数相加的一种实现方法
 * 还有一个是大数相乘
 */
public class Solution1 {
    public String addStrings(String num1, String num2) {
        //将字符串进行倒转把个位放在最前面，容易进行对齐相加
        char[] arr1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] arr2 = new StringBuilder(num2).reverse().toString().toCharArray();

        int length = Math.max(arr1.length, arr2.length);
//        int[] result=new int[length+1];
        int sum = 0;
        int carry = 0;    //进位数
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int a = i < arr1.length ? arr1[i] - '0' : 0;
            int b = i < arr2.length ? arr2[i] - '0' : 0;
            sum = a + b + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    /**
     * 模拟竖式乘法
     * https://leetcode-cn.com/problems/multiply-strings/solution/c-shu-shi-cheng-fa-dai-ma-jian-ji-you-ya-yi-dong-b/
     * m位和n位数相乘，结果最大长度是m+n
     * 乘法这里必须使用双循环，因为加法只要每位对齐相加就行，而乘法要循环相乘
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        char[] arr1=num1.toCharArray();
        char[] arr2=num2.toCharArray();
        int[] result=new int[len1+len2];
        int temp=0;
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                temp=result[i+j+1]+(arr1[i]-'0')*(arr2[j]-'0');
                result[i+j+1]=temp%10;
                result[i+j]+=temp/10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<len1+len2;i++){
            if (result[i]==0){
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
