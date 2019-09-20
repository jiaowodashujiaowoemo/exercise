package 八月24;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/24,16:25
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        Map<Integer,Integer> map=new LinkedHashMap<>();
        for (int i=0;i<n;i++){
            int x=scanner.nextInt();
            if (map.containsKey(x)){
                int y=map.get(x)+1;
                map.put(x,y);
            }else {
                map.put(x,1);
            }
        }
        System.out.println(map.entrySet());
        StringBuffer sb=new StringBuffer();
        for (Map.Entry entry:map.entrySet()){
            int key= (int) entry.getKey();
            int value= (int) entry.getValue();
            if (value<=m){
                for(int i=0;i<value;i++){
                    sb.append(key+" ");
                }
            }
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
}
