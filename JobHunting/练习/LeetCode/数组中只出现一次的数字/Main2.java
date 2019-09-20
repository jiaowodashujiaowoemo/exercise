package LeetCode.数组中只出现一次的数字;

/**
 * Created by ChenXiang
 * 2019/08/25,20:46
 * 还是找数字，但是有只出现了一次的数字有两个
 */
public class Main2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        find(arr);
    }

    public static void find(int[] arr) {
        int sum = 0;//全部的数相异或的值
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ arr[i];     //由于两个相同的数异或的结果是0，所以这个值最后得到的是两个只出现了一次的数字的异或结果
        }
        int sum0 = sum;
        int i = 0;
        for (; i < 32; i++) {     //求这个两个数的二进制形式第一次出现不同是在第几位
            if ((sum & 1) == 0) {
                sum = sum >> 1;
            } else if ((sum & 1) == 1) {
                break;
            }
        }

        int num1 = arr[0],
                num2 = 0;
        int tmp = 0;
        for (int s = 1; s < arr.length; s++) {
            tmp = arr[s] >> i;
            if ((tmp & 1) == 1) {       //根据第i位是不是1将数组分为两部分，一部分第i位是1，另一组第i位是0，每个子数组都只包含一个只出现了一次的数字
                num1 = arr[s] ^ num1;   //对第i位为1的那部分再进行一次异或，可以把重复的值都去掉，得到的就是第一个数（是第i位为0 的那个数）
            }
        }
        num2 = sum0 ^ num1;
        System.out.println(num1 + " " + num2);
    }
}
