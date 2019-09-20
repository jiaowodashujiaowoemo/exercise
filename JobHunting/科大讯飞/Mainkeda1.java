import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/12,10:15
 */
public class Mainkeda1 {
    public static String addBigNum(String num1, String num2) {
        //1. String转为char数组
        //因为num1, num2 可能位数不一样，比如num1=123， num=1234, 翻转两个字符串后，个位十位相加比较方便
        char[] num1Chars = new StringBuffer(num1).reverse().toString().toCharArray();
        char[] num2Chars = new StringBuffer(num2).reverse().toString().toCharArray();

        int num1Length = num1Chars.length;
        int num2Length = num2Chars.length;
        //2. 在长的数组长度上加一来存新数组
        int maxLength = Math.max(num1Length,num2Length);
        int[] result = new int[maxLength + 1];

        //3. 对位相加
        for (int i = 0; i < result.length; i++) {
            // 如果当前的i超过了某个数组的长度，就用0代替高位了，和另一个字符数组中的数字相加
            int aint = i < num1Length ? (num1Chars[i] - '0') : 0;
            int bint = i < num2Length ? (num2Chars[i] - '0') : 0;
            //result[i]可能已经有值了，是前面一位运算(i-1)进位过来的，所以不能直接赋值，要 +=
            result[i] += aint + bint;

            //如果大于10的就向前一位进位，本身进行除10取余
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }

        //4. 存储最后的结果
        StringBuffer sb = new StringBuffer();
        //判断最高位是0还是1, 0无需保存
        if (result[result.length - 1] == 1)
            sb.append(1);
        for (int i = result.length - 2; i >= 0; i--) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        String num1 = "11111111111111111111111111111";
//        String num2 = "99999999999999999999999999999";
//
//        String result = addBigNum(num1, num2);
//        System.out.println("result: " + result);
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        String str2=scanner.nextLine();
        System.out.println(addBigNum(str1,str2));
    }
}