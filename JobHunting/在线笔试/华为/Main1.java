package 华为;

import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/21,19:37
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        String[] strings=input.split(" ");
        int count=0;
        for (int i=0;i< strings.length;i++){
            if (strings[i].equals("A")){
                strings[i]="12 34";
                count++;
            }
            if (strings[i].equals("B")){
                strings[i]="AB CD";
                count++;
            }
        }
        count+=strings.length;
        System.out.print(String.valueOf(Integer.toHexString(count)).toUpperCase());
        for (int i=1;i<strings.length;i++){
            System.out.print(" "+strings[i]);
        }

    }
}

//8 1 2 3 4 5 6 A
