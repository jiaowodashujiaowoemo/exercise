package LeetCode.丑数;

/**
 * Created by ChenXiang
 * 2019/08/29,20:09
 * 从小到大找出第index个丑数
 */
public class Solution2 {
    public int GetUglyNumber_Solution(int index) {
        if (index<=0){
            return 0;
        }
        int[] uglyNumbers=new int[index];
        uglyNumbers[0]=1;
        int nextIndex=1;
        int multiply2=0;
        int multiply3=0;
        int multiply5=0;

        while (nextIndex<index){
            uglyNumbers[nextIndex]=min(uglyNumbers[multiply2]*2,uglyNumbers[multiply3]*3,uglyNumbers[multiply5]*5);
            while (uglyNumbers[multiply2]*2<=uglyNumbers[nextIndex]){
                multiply2++;
            }
            while (uglyNumbers[multiply3]*3<=uglyNumbers[nextIndex]){
                multiply3++;
            }
            while (uglyNumbers[multiply5]*5<=uglyNumbers[nextIndex]){
                multiply5++;
            }
            nextIndex++;
        }
        return uglyNumbers[index-1];
    }

    public int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().GetUglyNumber_Solution(1500));
    }
}
