package 春招.携程.第二题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author ChenXiang
 * @Date 2019/04/08,19:53
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int x = sc.nextInt();
        String[] strings = s.split(",|\\[|\\]");
        List<Integer> list = new ArrayList<>();
        for (String string : strings) {
            list.add(Integer.getInteger(string));
        }


    }

    public static List<Integer> reverse(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        return result;
    }
}
