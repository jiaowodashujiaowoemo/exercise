package 春招.头条.二进制最长全一长度;

import java.util.Scanner;

/**
 * @Description 输入：长度，修改次数，二级制串
 * @Author ChenXiang
 * @Date 2019/04/27,11:29
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int changeNum = scanner.nextInt();
        int[] binaryStr = new int[length];
        int tmp;
        int numOf0=0;
        for (int i = 0; i < length; i++) {
            tmp=scanner.nextInt();
            binaryStr[i] = tmp;
            if (tmp==0){
                numOf0++;
            }
        }
        if (changeNum>=numOf0){
            System.out.println(length);
        }else {

        }
    }
}
