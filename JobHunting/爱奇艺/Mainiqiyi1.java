import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/08,15:26
 */
public class Mainiqiyi1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n-1];
        for (int i=0;i<n-1;i++){
            arr[i]=scanner.nextInt();
        }
    }
}
