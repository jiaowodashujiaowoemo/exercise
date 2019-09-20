import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/01,20:38
 */
public class Maint4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println(getSum(0,n-1,arr,0));
    }

    public static long getSum(int start,int end,int[] arr,long value){
        int q=start;
        long sum=0;
        int min=Integer.MAX_VALUE/2;
//        int length=end-start+1;
        if (start>end){
            return value;
        }
        for (int i=start;i<=end;i++){
            sum+=arr[i];
            if (arr[i]<min){
                min=arr[i];
                q=i;
            }
        }
        long tmp=sum*min;
        value=Math.max(tmp,value);

        long leftSum=getSum(start,q-1,arr,value);
        long rightSum=getSum(q+1,end,arr,value);
        return Math.max(leftSum,rightSum);
    }
}
