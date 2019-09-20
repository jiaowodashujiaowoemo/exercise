import com.sun.org.apache.bcel.internal.generic.INEG;
import com.sun.xml.internal.ws.encoding.ContentTypeImpl;

import java.util.*;

/**
 * Created by ChenXiang
 * 2019/08/24,19:39
 * 合唱队形
 * 创建三个数组：
 *     int[] height 保存每个人身高
 *     int[] leftMax 下标为i的学生左边(包括他自己)最高的学生
 *     int[] rightMin 下标为i的学生右边(包括他自己)最低的学生
 * 如果一个下标i，左边最高的(包括他自己) <= 右边最低的(不包括他自己)，那么就可以以他左边为界限分开
 */
public class Mainjd1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()){
            int count=scanner.nextInt();
            //特殊情况
            if (count==0){
                System.out.println(0);
                continue;
            }
            if (count==1){
                System.out.println(1);
                continue;
            }
            //获取身高
            int[] height=new int[count];
            for (int i=0;i<count;i++){
                height[i]=scanner.nextInt();
            }

            int[] leftMax=new int[count];
            int[] rightMin=new int[count];

            leftMax[0]=height[0];
            rightMin[count-1]=height[count-1];
            for (int i=1;i<count;i++){
                leftMax[i]= Math.max(leftMax[i-1],height[i]);
            }
            for (int i=count-2;i>=0;i--){
                rightMin[i]= Math.min(rightMin[i+1],height[i]);
            }
            int res=1;
            for (int i=0;i<count-1;i++){
                if (leftMax[i]<=rightMin[i+1]){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
