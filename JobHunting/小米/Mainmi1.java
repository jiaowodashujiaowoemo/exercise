
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/11,19:16
 */
public class Mainmi1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        if (list==null||list.size()==0){
            return;
        }
        int result=list.get(0);
        int max=result;
        for (int i=1;i<list.size();i++){
            max=Math.max(max+list.get(i),list.get(i));
            result=Math.max(result,max);
        }
        System.out.println(result);
    }
}
