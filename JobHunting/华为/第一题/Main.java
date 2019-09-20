package 第一题;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.time.temporal.Temporal;
import java.util.*;

/**
 * Created by ChenXiang
 * 2019/08/14,19:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String bin=Integer.toBinaryString(n);
//        System.out.println(bin);
        char[] chars=bin.toCharArray();
        int num=0;
        int pos=-1;
//        boolean flag=false;
        if(chars.length<3){
            System.out.print(0+" "+-1);
            System.exit(0);
        }
        for (int i=chars.length-1;i>=2;i--){
            if (chars[i]=='1'&&chars[i-1]=='0'&&chars[i-2]=='1'){
                num++;
                if (pos==-1){
                    pos=chars.length-i-1;
                }
            }
        }
        if (num==0){
            pos=-1;
        }
        System.out.println(num+" "+pos);
    }
}