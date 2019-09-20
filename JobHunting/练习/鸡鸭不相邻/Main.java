package 鸡鸭不相邻;

import java.util.Scanner;
/**
 * @Description
 * 农场有n只鸡鸭排为一个队伍，鸡用“C”表示，鸭用“D”表示。
 * 当鸡鸭挨着时会产生矛盾。需要对所排的队伍进行调整，使鸡鸭各在一边。每次调整只能让相邻的鸡和鸭交换位置
 * 现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。
 * 例如：CCDCC->CCCDC->CCCCD这样就能使之前的两处鸡鸭相邻变为一处鸡鸭相邻，需要调整队形两次。
 * @Author ChenXiang
 * @Date 2019/03/16,17:22
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input="";
        int result=0;

        input=scanner.nextLine();
        String[] s=input.split("");

        int l=0;
        for(int i=0;i<s.length;i++){
            if(s[i].equalsIgnoreCase("C")){
                result+=i-l;
                l++;
            }
        }

        System.out.println(result);
    }
}