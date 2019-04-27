package 春招.腾讯.零钱组合;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description 输入最大需要组合出的钱数，再输入面值的数量（假设每种面值的数量无数），再输入每个面值
 * https://www.nowcoder.com/discuss/173951
 * 输入
 * 第一行包含两个整数m, n,m是所需最大组合钱数，n是零钱数量。第二行包含n个整数，第i个整数表示第i种硬币的面值。
 * 输出
 * 输出一个整数，表示最少需要携带的硬币数量。如果无解，则输出-1。
 * @Author ChenXiang
 * @Date 2019/04/05,20:05
 */


public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int[] money=new int[n];
        for (int i=0;i<n;i++){
            money[i]=scanner.nextInt();
        }
        Arrays.sort(money);
        if (money[0]!=1){
            System.out.println(-1);
        }
        /**
         * num，ans，p表示：用前p种硬币组合出1到num之间的所有面值，至少需要ans个硬币。
         * 由于组合出num需要ans个硬币(这ans个硬币的面值之和即为num)，组合面值num+1时必须再增加一个硬币，
         * 问题是应该增加哪一种硬币呢？这里的贪心策略是选择面值不大于num+1的硬币中面值最大的那一个。
         */
        int num=0;
        int ans=0;
        int p=0;
        while (num<m){
            while (p<n-1 && money[p+1]<=num+1){
                //已经有序，这样去找不大于num+1的最大面值
                p++;
            }
            //然后把不大于num+1的值加上去
            num+=money[p];
            ans++;
//            System.out.println("%d,%d,%d" p,num,ans);
        }
        System.out.println(ans);
    }


    //下面是从栗殷师姐的python抄过来的
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        int n = scanner.nextInt();
//        int[] money = new int[n];
//        for (int i = 0; i < n; i++) {
//            money[i] = scanner.nextInt();
//        }
//        scanner.close();
//        if (0 == n || 1 != money[0]) {
//            System.out.println(-1);
//        } else {
//            int sum = 0;
//            int[] count = new int[n];
//            for (int i = 0; i < n; i++) {
//                count[i] = 0;
//            }
//            for (int i = 1; i <= m; i++) {
//                doSomething(i, count, money);
//            }
//            for (int i = 0; i < n; i++) {
//                sum = sum + count[i];
//            }
//            System.out.println(sum);
//        }
//
//    }
//
//    private static void doSomething(int p, int[] count, int[] money) {
//        Arrays.sort(money);
//        //找到需要凑的数p在所给面值的哪个区间内，也就是每次选择面值不大于num+1的硬币中面值最大的那个
//        int k = 0;
//        while (money[k] <= p) {
//            k++;
//            if (k == money.length)
//                break;
//        }
//        System.out.println(k);
//        //统计之前有的面值的总钱数是否和p相等，如果相等，count不变，不等，count[k-1]的个数要增加
//        int all = 0;
//        for (int i = 0; i < k; i++) {
//            all = all + count[i] * money[i];
//        }
//        if (all != p) {
//            count[k - 1] = Math.max(p / money[k - 1], count[k - 1]);
//        }
//
//        //计算每个面值的数量
//        if (1 == k) {
//            return;
//        } else {
//            int i = k - 2;
//            while (i >= 0) {
//                int temp = 0;
//                for (int j = i + 1; j < k; j++) {
//                    temp = temp + count[j] * money[j];
//                }
//                count[i] = Math.max((i - temp) / money[i], count[i]);
//                i--;
//            }
//        }
//        return;
//
//    }
}