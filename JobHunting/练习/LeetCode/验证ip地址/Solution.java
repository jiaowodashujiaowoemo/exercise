package LeetCode.验证ip地址;

/**
 * Created by ChenXiang
 * 2019/09/16,15:32
 * https://leetcode-cn.com/problems/validate-ip-address/
 * 可以认为没有其他特殊字符
 */
public class Solution {
    public String validIPAddress(String IP) {
        if (IP.startsWith(":")||IP.startsWith(".")|| IP.endsWith(":")||IP.endsWith(".")){
            return "Neither";
        }
        String[] splitted=IP.split("\\.");
        if (splitted.length==4){
            int num=-1;
            for(int i=0;i<4;i++){
                try {
                    num=Integer.parseInt(splitted[i]);
                }catch (NumberFormatException e){
                    return "Neither";
                }
                if (num<0||num>255){
                    return "Neither";
                }
            }
            return "IPv4";
        }else {
            splitted=IP.split(":");
            if (splitted.length==8){
                long num=-1;
                for (int i=0;i<8;i++){
                    if (splitted[i].length()>4||splitted[i].startsWith("-")){
                        return "Neither";
                    }
                    try {
                        num=Long.parseLong(splitted[i],16);
                    }catch (NumberFormatException e){
                        return "Neither";
                    }
                    if (num<0){
                        return "Neither";
                    }
                }
                return "IPv6";
            }else {
                return "Neither";
            }
        }
    }
}
