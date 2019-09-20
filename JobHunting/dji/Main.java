
import com.sun.javafx.font.Metrics;
import com.sun.org.apache.xalan.internal.xsltc.trax.SmartTransformerFactoryImpl;

import java.util.Scanner;

/**
 * @Author ChenXiang 邻接矩阵最短路径，直接Floyd算法
 * @Date 2019/8/4,21:39
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //路标的数目
        int n=0;
        //可以移动的路标通路数目；
        int p=0;
        //要进行比赛的轮数
        int c=0;
        //每一组输入的比赛路标
        int[] points;
        //距离矩阵
        int[][] metrix;
        int row;
        int col;
        int cost;
        while (scanner.hasNext()){
            n=scanner.nextInt();
            p=scanner.nextInt();
            c=scanner.nextInt();
            points=new int[c];
            metrix=new int[n][n];
            //输入距离矩阵
//            int num=p*3;

            for (int j=0;j<p;j++){
//                    for (int i=0;i<3;i++){
                row=scanner.nextInt();
                col=scanner.nextInt();
                cost=scanner.nextInt();
                metrix[row][col]=cost;
                metrix[col][row]=cost;

//                    }

            }
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if (metrix[i][j]==0){
                        metrix[i][j]=Integer.MAX_VALUE/2;
                    }
                }
            }

            //输入比赛轮数
            for (int i=0;i<c;i++){
                points[i]=scanner.nextInt();
            }

            System.out.println(calculate(metrix,points));

        }


    }


    public static int calculate(int[][] metrix,int[] points){
        int cost=0;
        //点的数量
        int rows=metrix[0].length;
        int[][] dp=new int[rows][rows];
        dp[0][0]=metrix[0][0];
        for (int k=1;k<rows;k++){//k是中转点
            for (int i=0;i<rows;i++){
                for (int j=0;j<rows;j++){
                        if (metrix[i][j]> metrix[i][k]+metrix[k][j]){
                            metrix[i][j]= metrix[i][k]+metrix[k][j];
                        }
                }
            }
        }
//        for (int i=1;i<rows;i++){
//            dp[i][0]=dp[i-1][0]+metrix[i][0];
//        }
//        for (int i=1;i<rows;i++){
//            dp[0][i]=dp[0][i-1]+metrix[0][i];
//        }
//        for (int i=1;i<rows;i++){
//            for (int j=1;j<rows;j++){
//                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]+metrix[i][j]);
//            }
//        }
//        for (int i=0;i<points.length;i++){
//            cost+=dp[points[i]][points[i]];
//        }
        for (int i=0;i<points.length;i++){
            cost+=metrix[0][points[i]];
        }
        return cost;
    }

}