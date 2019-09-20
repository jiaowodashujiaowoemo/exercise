package 中兴;

/**
 * Created by ChenXiang
 * 维克多博士，多限制的01背包问题
 * 2019/08/25,10:22
 */
public class Main {
    public static void main(String[] args) {

    }

    public static int maxEnergy(int reactorCap, int n, int maxmass, int[] vol,int[] mass,int[] ener){
        if (n<1){
            return 0;
        }
        int[][] dp=new int[maxmass+1][reactorCap+1];
        for (int i=0;i<n;i++){
            for (int j=dp.length-1;j>0;j--){
                for (int k=dp[j].length-1;k>0;k--){
                    if (vol[i]<=k&&mass[i]<=j){
                        dp[j][k]=Math.max(dp[j][k],dp[j-mass[i]][k-vol[i]]+ener[i]);
                    }
                }
            }
        }
        return dp[maxmass][reactorCap];
    }


}
