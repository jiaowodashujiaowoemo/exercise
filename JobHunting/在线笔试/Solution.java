import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChenXiang
 * 2019/09/29,16:54
 */
public class Solution {
    public String intToRoman(int num) {
        int[] numArr=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strArr=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuffer sb=new StringBuffer();
        if (num<0||num>3999){
            return null;
        }
        for (int i=0;i<numArr.length;i++){
            int temp=num/numArr[i];
            while (temp>0){
                sb.append(strArr[i]);
                temp--;
            }
            num=num%numArr[i];
        }
        return sb.toString();
    }
}
