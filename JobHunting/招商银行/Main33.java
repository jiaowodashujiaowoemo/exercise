//import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
//
//import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
//import java.nio.file.attribute.AclEntryType;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * Created by ChenXiang
// * 2019/09/15,21:47
// */
//public class Main33 {
//    static Map<Integer,Character> map=new HashMap<>();
//    static int bit=0;
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        String string=scanner.nextLine();
//        rule(string);
//    }
//
//    public static boolean isGood(int num){
//        String string=String.valueOf(num);
//        char[] arr=string.toCharArray();
//        if (arr.length<bit){
//            char[] newarr=new char[bit];
//            for (int i=0;i<bit-arr.length;i++){
//                newarr[i]='0';
//            }
//            for (int i=bit-arr.length;i<bit;i++){
//                newarr[i]=arr[bit-arr.length-i];
//            }
//            arr=newarr;
//        }
//
//
//    }
//
//    public static void rule(String string){
//        char[] arr=string.toCharArray();
//        bit=arr.length;
//        for (int i=0;i<arr.length;i++){
//            if (arr[i]!='?'){
//                map.put(i,arr[i]);
//            }
//        }
//    }
//}
