package 剑指offer.字符串空格替换;

/**
 * @Description
 * @Author ChenXiang
 * @Date 2019/03/21,16:14
 */

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Main {
    /**
     * @param strOld
     * @return
     */
    public static String SpaceReplace1(String strOld) {
        String[] split = strOld.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            stringBuilder.append(split[i]).append("%20");
        }
        stringBuilder.append(split[split.length - 1]);
        String strNew = stringBuilder.toString();
        return strNew;
    }

    /**
     * @param strOld
     * @param len
     */
    public static void SpaceReplace2(String strOld, int len) {
        char[] chs = new char[len];
        char[] ch = strOld.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            chs[i] = ch[i];
        }

        int strOldLen = 0;
        int blackString = 0;
        if (chs == null || len <= 0) {
            new NullPointerException();
        }

        int i = 0;
        while (chs[i] != '\0') {
            strOldLen++;
            if (chs[i] == ' ') {
                blackString++;
            }
            i++;
        }
        //将空格转换成%20字符的长度
        int strNewLen = strOldLen + blackString * 2;
        if (strNewLen > len) {
            new ArrayIndexOutOfBoundsException();
        }

        int indexOfOld = strOldLen;//指向'\0'
        int indexOfNew = strNewLen;

        while (indexOfOld > 0 && indexOfNew > indexOfOld) {
            if (chs[indexOfOld] == ' ') {
                chs[indexOfNew--] = '0';
                chs[indexOfNew--] = '2';
                chs[indexOfNew--] = '%';
            } else {
                chs[indexOfNew--] = chs[indexOfOld];
            }
            --indexOfOld;
        }
        for (char c : chs) {
            if (c == '\0') {
                break;
            }
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello world");
        System.out.println(new Main().replaceSpace(stringBuffer));
    }

    /**
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        if (0 == str.length() || null == str) {
            return null;
        }
        return str.toString().replaceAll(" ", "%20");
    }
}