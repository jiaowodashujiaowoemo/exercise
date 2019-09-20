package LeetCode.丑数;

/**
 * Created by ChenXiang
 * 2019/09/11,21:35
 * 判断给定的数是不是丑数
 * 丑数是只有2,3,5因子的数
 * 1是丑数
 */
public class Solution1 {
    public boolean isUgly(int num) {
        if (num<=0){
            return false;
        }
        while (num!=1){
            if (num%2==0){
                num=num/2;
            }else if (num%3==0){
                num=num/3;
            }else if (num%5==0){
                num=num/5;
            }else {
                return false;
            }
        }
        return true;
    }
}
