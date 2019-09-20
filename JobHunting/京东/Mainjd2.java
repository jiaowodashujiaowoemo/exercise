import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/24,19:34
 */
public class Mainjd2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();

        int[][] arr=new int[n+1][m+1];
        for (int i=0;i<m;i++){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            if (x>y){
                x=x-n;
                arr[y-1][x-1]=1;
            }else {
                y=y-n;
                arr[x-1][y-1]=1;
            }
//            arr[x][y]=1;
        }
        List<Integer> result=new ArrayList<>();
        int sum=0;
        for (int i=0;i<n+1;i++){
            int col=0;
            for (int j=0;j<n+1;j++){
                col+=arr[j][i];
            }
            arr[n][i]=col;
            if (col>sum){
                sum=col;
                result.clear();
                result.add(i+n+1);
            }


        }
        for (int i=0;i<n+1;i++){
            int row=0;
            for (int j=0;j<n+1;j++){
                row+=arr[i][j];
            }
            arr[i][n]=row;
            if (row>sum){
                result.clear();
                result.add(i+1);
                sum=row;
            }
        }

        System.out.println(result.size());
        for (int i:result){
            System.out.println(i+" ");
        }
    }
}
