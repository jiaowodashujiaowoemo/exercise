import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ChenXiang
 * 2019/09/11,16:04
 */
public class Mainvivo1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr );
        System.out.println(output);
    }

    private static int solution(String str) {
        int left=0,right=0;
        for (int i=0;i<str.length();i++){
            if (str.substring(i,i+1).equals("(")){
                left++;
            }else if (str.substring(i,i+1).equals(")")){
                right++;
            }else {
                break;
            }
        }
        return left-right;
//        int result1=0;
//        while (chars[j]!='0'){
//            if (chars[j]==')'){
//                result1++;
//            }
//            j--;
//        }
//        return Math.min(result,result1);
    }
}
