import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/31,16:40
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        String[] list=string.split(",");
        System.out.println(getMinVersion(list));
    }
    public static String getMinVersion(String[] list) {
        // 在这里编写代码
        if (list.length==0||list==null){
            return null;
        }
        if (list.length==1){
            return list[0];
        }
        String result="";
        for (int i=0;i<list.length-1;i++){
            result=list[i].compareTo(list[i+1])==-1?list[i]:list[i+1];
        }
        return result;
    }
}
