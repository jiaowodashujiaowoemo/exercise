import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/20,19:35
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String result="";
        String[] strings=str.split(" ");
        for (int i=strings.length-1;i>0;i--){
            result+=strings[i]+" ";
        }
        result+=strings[0];
        System.out.println(result);
    }
}
