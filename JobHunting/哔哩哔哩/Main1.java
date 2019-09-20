
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/20,19:26
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String[] strings=str.split(",");
        Arrays.sort(strings, (a, b) -> {
            String s1=a+b;
            String s2=b+a;
            return s1.compareTo(s2);
        });

        StringBuffer sb=new StringBuffer();
        for (int i=0;i<strings.length;i++){
            sb.append(strings[i]);
        }
        System.out.println(sb.toString());
    }
}
