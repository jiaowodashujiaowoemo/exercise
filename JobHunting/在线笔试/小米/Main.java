package 小米;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/06,19:40
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int res;
        int prices_size=0;
        prices_size=Integer.parseInt(scanner.nextLine().trim());
        int[] prices=new int[prices_size];
        int prices_item;
        for (int i=0;i<prices_size;i++){
            prices_item=Integer.parseInt(scanner.nextLine().trim());
            prices[i]=prices_item;
        }

        int budget;
        budget=Integer.parseInt(scanner.nextLine().trim());

        res=solution(prices,budget);
        System.out.println(res);
    }

    static int solution(int[] prices,int budget){
        Arrays.sort(prices);
        int res=0;
        for (int i=prices.length-1;i>=0;i++){
            res=res+budget/prices[i];
            budget=budget%prices[i];
            if (budget==0){
                break;
            }
        }
        if (budget!=0){
            return -1;
        }
        return res;
    }
}
