package LeetCode.使序列递增的最小交换次数华为面试;

/**
 * Created by ChenXiang
 * 2019/09/09,22:10
 * https://blog.csdn.net/weixin_37373020/article/details/81561750
 */
public class Main {
    public int minSwap(int[] A,int[] B){
        int[] swap=new int[A.length];
        int[] keep=new int[A.length];
        keep[0]=0;
        swap[0]=1;//第一个元素交换可以使它们有序，如果不交换也可以有序
        for (int i=1;i< A.length;i++){
            keep[i]=swap[i]=Integer.MAX_VALUE;
            if (A[i]>A[i-1]&&B[i]>B[i-1]){
                swap[i]=swap[i-1]+1;
                keep[i]=keep[i-1];
            }
            if (A[i]>B[i-1]&&B[i]>A[i-1]){
                keep[i]=Math.min(keep[i],swap[i-1]);
                swap[i]=Math.min(swap[i],keep[i-1]+1);
            }
        }
        return Math.min(keep[A.length-1],swap[A.length-1]);
    }
}
