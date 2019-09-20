import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/27,19:41
 * 项目分配
 */
public class Maindd1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] arr=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                arr[i][j]=scanner.nextInt();
            }
        }

        int result=0;
        for (int i=0;i<m;i++){
            int tmp=arr[0][i];
            for (int j=0;j<n-1;j++){
                tmp=Math.max(tmp,arr[j+1][i]);
            }
            result+=tmp;
        }

        System.out.println(result);
    }
}
