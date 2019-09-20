package qihu360;

import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/15,19:56
 * 正方体叠加后立体图形的表面积
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] matrix=new int[n][m];
        int num=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                matrix[i][j]=scanner.nextInt();
                num+=matrix[i][j];
            }
        }

        int total=num*6;


    }
}
//import java.util.*;
//
//public class Main {
//    public static void solution(int[][] input, int n, int m, int total){
//        for(int i = 0; i < n; i++){  //每行遍历
//            for(int j = 0; j < m ; j++){ //每列遍历
//                if(input[i][j] != 0){
//                    total -= (input[i][j] - 1) * 2;
//                }
//            }
//        }
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m - 1; j++){
//                int face = Math.min(input[i][j], input[i][j + 1]);
//                total -= face * 2;
//            }
//        }
//        for(int i = 0; i < n - 1; i++){  //每列遍历
//            for(int j = 0; j < m; j++){ //每列遍历
//                int face = Math.min(input[i][j], input[i + 1][j]);
//                total -= face * 2;
//            }
//        }
//        System.out.println(total);
//    }
//
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[][] input = new int[n][m];
//        int  total = 0;
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                input[i][j] = scanner.nextInt();
//                total += input[i][j];
//            }
//        }
//        Main.solution(input, n, m, total * 6);
//
//    }
//
//}