package 春招.腾讯.零钱组合;

/**
 * @Description 输入最大需要组合出的钱数，再输入面值的数量（假设每种面值的数量无数），再输入每个面值
 * @Author ChenXiang
 * @Date 2019/04/05,20:05
 */

/**
 * 零钱组合问题，求出最少需要多少张纸币可以组合出1-M中每一个数字，采用自顶向下的贪心算法。
 * 分析：如果M=20，那么拿出一张p元的纸币后，下一次需要组合出20-p与p-1的最大值的，
 *      就是说下一次的M=max(M-p,p-1),那么我们每次拿出的纸币希望能得到最小的M，反复循环直到M为0
 */
public class Main{
    public static void main(String[] args) {

    }
}