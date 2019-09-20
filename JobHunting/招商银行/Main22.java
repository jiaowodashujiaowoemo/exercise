import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/15,21:01
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] arr=new int[n+1][n+1];
        int lastNotleaf=0;
        for (int i=0;i<n-1;i++){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            int z=scanner.nextInt();
            lastNotleaf=Math.max(x,lastNotleaf);
            arr[x][y]=z;
        }

        for (int i=0;i<n+1;i++){
            for (int j=0;j<n+1;j++){
                if (arr[i][j]==0){
                    arr[i][j]=Integer.MIN_VALUE/2;
                }
            }
        }

        for (int k=1;k<=n;k++){
            for (int i=1;i<=n;i++){
                for (int j=1;j<=n;j++){
                    if (arr[i][j]<arr[i][k]+arr[k][j]){
                        arr[i][j]=arr[i][k]+arr[k][j];
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i=1;i<=lastNotleaf;i++){
            int max=0;
            for (int j=1;j<=n;j++){
                max=Math.max(max,arr[i][j]);
            }
            sb.append(max+" ");
        }
        for (int i=lastNotleaf+1;i<=n;i++){
            sb.append(0+" ");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
}
