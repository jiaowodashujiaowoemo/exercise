package LeetCode.数组中只出现一次的数字;

/**
 * Created by ChenXiang
 * 2019/09/11,14:28
 * 数组中某个元素只出现了一次，其余元素都出现了三次，找出只出现了一次的数字
 * 如果其他数字都出现了k次，只要把3改成k就可以
 */

/**
 * 1.位运算求解此题;
 * 2.如果把所有出现三次的数字的二进制表示的每一位加起来,那么每一位都能被3整除;
 * 3.如果某一位的和能被3整除,那么只出现一次数字的二进制位中对应的那一位就是0,否则就是1;
 * 4.完结。
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 2, 2, 1, 1, 1, 1, 3}));
    }

    public static int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for (int j = 0; j < 32; j++) {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i] >> j;
                bit[j] += num & 1;
            }
        }
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result <<= 1;
            result += bit[i] % 3;
        }
        return result;
    }
}
