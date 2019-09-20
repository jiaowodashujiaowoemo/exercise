package 剑指offer.数组排成最小的数;

import java.util.Arrays;

/**
 * Created by ChenXiang
 * 2019/09/14,20:56
 */
public class Main {
    public String PrintMinNumber(int [] numbers) {
        if(numbers==null||numbers.length<0){
            return "";
        }
        StringBuilder result=new StringBuilder();
        Integer[] arr=new Integer[numbers.length];
        for (int i=0;i<numbers.length;i++){
            arr[i]=numbers[i];
        }
        Arrays.sort(arr,(a,b)->{
            String s1=a+""+b;
            String s2=b+""+a;
            return s1.compareTo(s2);
        });

        for (Integer integer:arr){
            result.append(integer);
        }
        return result.toString();
    }
}
