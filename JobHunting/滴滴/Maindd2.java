import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/27,20:00
 * 规定若a<b，则a的字典序在b之前，不考虑括号
 */
//6
//3 + 2 + 1 + -4 * -5 + 1
public class Maindd2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String string=scanner.nextLine();
        System.out.println(string);
        String[] all=string.split("\\ + | - |\\ * | / ");

        int[] ints=new int[n];
        String[] ops=new String[n-1];
        for (int i=0;i<n;i++){
            ints[i]=Integer.valueOf(all[2*i]);
            ops[i]=all[2*i+1];
        }

        for (int i=0;i<n-1;i++){
            switch (ops[i]){
                case "+":
                case "-":

            }
        }
    }
}