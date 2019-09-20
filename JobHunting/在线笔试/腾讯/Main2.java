package 腾讯;

import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by ChenXiang
 * [0,L]的数轴，n个视野，dii个可以覆盖[xi,yi]，至少几个视野可以覆盖整个数轴
 * 2019/08/17,21:32
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int l=scanner.nextInt();
        Map<Integer,Integer> map=new TreeMap<>();
        for (int i=0;i<num;i++){
            map.put(scanner.nextInt(),scanner.nextInt());
        }
        int y=0;
        int sum=0;
        int count =0;

        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (y<=entry.getValue()){
                if (entry.getKey()!=0){
                    int s=entry.getValue()-entry.getKey();
                }else {
                    int s=entry.getValue()-y;
                }
                int s=entry.getValue()-y;
                if (sum<l){
                    sum+=s;
                    y=entry.getValue();
                    count++;
                }else {
                    break;
                }
            } else {
              y=0;sum=0;
              count=0;
            }
        }
        if (sum>=l){
            System.out.println(count);
        }else   {
            System.out.println(-1);
        }
    }
}
