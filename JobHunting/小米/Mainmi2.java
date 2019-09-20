import javax.xml.bind.PrintConversionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/11,19:32
 * 股票交易，只能交易两次，求最大利润
 */
public class Mainmi2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        int buy1=Integer.MIN_VALUE;
        int buy2=Integer.MIN_VALUE;
        int sell1=0;
        int sell2=0;
        for (int i=0;i<list.size();i++){
            sell2=Math.max(buy2+list.get(i),list.get(i));
            buy2=Math.max(buy2,sell1-list.get(i));
            sell1=Math.max(buy1,sell1+list.get(i));
            buy1=Math.max(buy1,-list.get(i));
        }
        System.out.println(sell2);
    }
}
