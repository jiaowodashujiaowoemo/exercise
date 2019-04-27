package 春招.完美世界.第一题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description 网站上ace了，但是并不能通过所有用例，用5和3凑12，还是得用动态规划
 * @Author ChenXiang
 * @Date 2019/04/15,19:56
 */

/**
 * 2
 * 5 3
 * 12
 * 应该输出4
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();//面值个数
        int[] arr=new int[n];//各面值
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int goal=scanner.nextInt();//要凑出来的钱
        int[] max=new int[goal+1];//最多需要多少
        int[] min=new int[goal+1];//最少需要多少
        Arrays.sort(arr);
        if (arr[0]>goal){
            System.out.println(-1);
        }else {
//            int result=0;
//            for (int i=n-1;i>=0;i--){
//                result+=goal/arr[i];
//                int tmp=goal%arr[i];
//                if (0==tmp){
//                    System.out.println(result);
//                    System.exit(0);
//                }else {
//                    goal=tmp;
//                }
//            }
//            System.out.println(-1);
            for (int i=1;i<=goal;i++){
                for (int j=0;j<n;j++){
                    if (i-arr[j]>=0){
//                        max[i]=Math.max(max[i],max[i-arr[j]]+1);
//                        min[i]=Math.min(min[i],min[i-arr[j]]+1);
                        min[j]=min[j]+min[j-arr[i]];
                    }
                }
            }
        }
        System.out.println(min[goal]);
    }
}
