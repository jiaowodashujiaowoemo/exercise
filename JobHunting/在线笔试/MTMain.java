import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * Created by ChenXiang
 * 2019/08/22,14:07
 */
public class MTMain {
    public static void main(String[] args) {
        String string = "fgfjkrtyvbnghjdfghj";
//        String string = "fgf";
        List<String> results = new ArrayList<>();
        int maxLen = 0;
        int curLen = 1;
        StringBuffer temp = new StringBuffer(string.substring(0, 1));
        int i = 0;
        int j = i + 1;
        while (i < string.length() && j < string.length()) {
            String nextChar = string.substring(j, j + 1);
            if (!temp.toString().contains(nextChar)) {
                temp.append(nextChar);
                curLen++;
                j++;
            } else {
                if (curLen > maxLen) {
                    results.clear();
                    maxLen = curLen;
                    results.add(temp.toString());
                    i++;
                } else if (curLen == maxLen) {
                    if (!results.contains(temp.toString())) {
                        results.add(temp.toString());
                        i++;
                    }
                }
                j = i + 2;
                temp.setLength(0);
            }
        }

        for (String str : results) {
            System.out.println(str);
        }
    }
}
