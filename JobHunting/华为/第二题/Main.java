package 第二题;

import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/08/14,19:53
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s0 = scanner.nextLine();
//        String[] strings=str.split(",");
        String s1 = s0.replaceAll(",\"\"", "~");
        String[] s = s1.split(",");
        for (int i = 0; i < s.length; i++) {
            if (s[i].contains("~")) {
                if (String.valueOf(s[i].charAt(0)).equals("\"") && String.valueOf(s[i].charAt(s[i].length() - 1)).equals("\"")) {
                    s[i] = s[i].substring(1, s[i].length() - 1);
                    if (s[i].contains("\"")) {
                        System.out.println("ERROR");
                        return;
                    }
                } else {
                    System.out.println("ERROR");
                    return;
                }
            } else {
                if (String.valueOf(s[i].charAt(0)).equals("\"") && String.valueOf(s[i].charAt(s[i].length() - 1)).equals("\"")) {
                    s[i] = s[i].substring(1, s[i].length() - 1);
                    if (s[i].contains("\"")) {
                        System.out.println("ERROR");
                        return;
                    }
                } else if (s[i].equals("")) {
                    s[i] = "--";
                }
            }

        }
        System.out.println(s.length);
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i].contains("~")) {
                s[i] = s[i].replaceAll("~", "'\"");
            }
            System.out.println(s[i]);

        }
        System.out.print(s[s.length - 1]);
    }
}

//    public static boolean isIlegal(String str){
//        int numofYinhao=0;
//        for (int i=0;i<str.length();i++){
//            if (str.charAt(i)=='\"'){
//                numofYinhao++;
//            }
//        }
//        if (numofYinhao%2!=0){
//            return false;
//        }
//
//        if (str.contains(",")){
//            if (str.startsWith("\"")&&str.endsWith("\"")){
//                str=str.substring(1,str.length()-1);
//            }else if (!str.startsWith("\"")&&!str.endsWith("\"")){
//
//            } else {
//                return false;
//            }
//        }else {
//            if (str.startsWith("\"")&&str.endsWith("\"")){
//                str=str.substring(1,str.length()-1);
//            }else {
//                return true;
//            }
//        }
//    }

