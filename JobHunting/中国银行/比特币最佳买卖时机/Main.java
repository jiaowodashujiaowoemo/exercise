package 比特币最佳买卖时机;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.util.List;
import java.util.Scanner;
/**
 * @Description 给定一个正整数数组，它的第 i 个元素是比特币第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一次），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入比特币前卖出。
 * @Author ChenXiang
 * @Date 2019/03/17,16:03
 */

/**
 * 最低价格买入，最高价格卖出
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
//        int min = scanner.nextInt();
        int max = 0;
        int temp;
        while (scanner.hasNext()) {
            temp = scanner.nextInt();
            max = Math.max(max, temp - min);
            min = Math.min(min, temp);
        }
        System.out.println(max);
    }
}
