package LeetCode.数组中只出现一次的数字;

/**
 * Created by ChenXiang
 * 2019/08/25,20:42
 * 数组中有一个数字只出现了一次，其他都出现了两次，找出这个数字，要求复杂度为O（n）
 * 思路：相同数字异或结果为0
 */
public class Main1 {
    public static void main(String[] args) {
        int[] a={1,2,3,1,2,4,4};
        if (a.length<2){
            return;
        }

        int result=0;
        for (int i=0;i<a.length;i++){
            result=result^a[i];
        }

        System.out.println(result);
    }
}
