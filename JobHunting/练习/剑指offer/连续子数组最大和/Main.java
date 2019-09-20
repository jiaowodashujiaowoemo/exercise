package 剑指offer.连续子数组最大和;

/**
 * Created by ChenXiang
 * 2019/09/11,21:22
 */
public class Main {
    public static void main(String[] args) {

    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int max = result;
        for (int i = 1; i < array.length; i++) {
            max = Math.max(array[i], max + array[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}
