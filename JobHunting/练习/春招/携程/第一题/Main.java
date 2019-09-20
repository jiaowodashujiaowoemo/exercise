package 春招.携程.第一题;

import java.util.*;

/**
 * @Author ChenXiang
 * @Date 2019/04/08,19:35
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(",");
        String temp = strings[0];
        boolean flag = false;
        List<String> list = new ArrayList<String>(Arrays.asList(strings));
        Set<String> set = new HashSet<String>(Arrays.asList(strings));
        if (list.size() == set.size()) {
        } else {
            flag = true;
        }
        System.out.println(flag);
    }
}
