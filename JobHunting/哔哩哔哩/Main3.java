import java.util.Scanner;

/**
 * Created by ChenXiang
 * 背包问题
 * 2019/08/20,19:49
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int total=scanner.nextInt();//背包承重
        int[] weight=new int[n+1];
        int[] value=new int[n+1];
        int[] dp=new int[total+1];
        for (int i=1;i<=n;i++){
            weight[i]=scanner.nextInt();
        }
        for (int i=1;i<=n;i++){
            value[i]=scanner.nextInt();
        }
        for (int i=1;i<=n;i++){
            for (int j=total;j>=weight[i];j--){
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(dp[total]);

    }


}
