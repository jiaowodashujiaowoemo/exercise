package 春招.腾讯;

import java.util.Scanner;

/**
 * @Description
 * @Author ChenXiang
 * @Date 2019/04/05,20:20
 */
public class 第二题 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
       String s=sc.next();
       char[] chr=s.toCharArray();
       int count=0;
       for (int i=0;i<n;i++){
           if (chr[i]=='0'){
               count++;
           }
       }
        System.out.println(Math.abs(n-2*count));
    }
}
