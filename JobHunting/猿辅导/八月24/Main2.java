package 八月24;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.*;

/**
 * Created by ChenXiang
 * 2019/08/24,16:44
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int c=scanner.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<c;i++){
            int x=scanner.nextInt();
            List<Integer> data=new ArrayList<>();
            for (int j=0;j<x;j++){
                data.add (scanner.nextInt());
            }
            list.add(getResult(data));
        }
        for (Integer i:list){
            System.out.println(i);
        }

    }

    public static int getResult(List<Integer> data){
        int total=0;
        Collections.sort(data);
        Collections.reverse(data);

        for (int i=0;i<data.size();i++){
            System.out.println(data.get(i));
        }
        if (data.size()>2){
            while (data.get(2)!=0){
                total+=data.get(2);
                data.add(data.get(0)-data.get(2));
                data.add(data.get(1)-data.get(2));
                data.remove(0);
                data.remove(1);
                data.remove(2);
                Collections.sort(data);
                Collections.reverse(data);
            }
        }

        return total;
    }
}
