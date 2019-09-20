//package 第一题;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * Created by ChenXiang
// * 2019/08/11,15:05
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
//        double[] arr=new double[n];
//        for (int i=0;i<n;i++){
//            arr[i]=scanner.nextInt();
//        }
//        Arrays.sort(arr);
//        double result=calculate(arr[0],arr[1],arr[2]);
//        for (int i=1;i<n-2;i++){
//            result=Double.min(result,calculate(arr[i],arr[i+1],arr[i+2]));
//        }
//        System.out.println(String.format("%.2f",result));
//    }
//
//    public static double calculate(double x, double y, double z){
//        double sum=x+y+z;
////        System.out.println((Math.pow(x-sum/3,2)));
//        double d=(((Math.pow(x-sum/3,2)+Math.pow(y-sum/3,2)+Math.pow(z-sum/3,2))));
//        BigDecimal b =new BigDecimal(d);
////        System.out.println(d);
//
//        BigDecimal divisor=new BigDecimal(3);
//        double result= b.divide(divisor,2, BigDecimal.ROUND_HALF_UP).doubleValue();
//        return result;
//    }
//}
