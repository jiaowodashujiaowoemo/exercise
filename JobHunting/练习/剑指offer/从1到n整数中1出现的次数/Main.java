package 剑指offer.从1到n整数中1出现的次数;

/**
 * Created by ChenXiang
 * 2019/09/11,22:04
 */
public class Main {
    /**
     * https://blog.csdn.net/yi_afly/article/details/52012593
     * 对个位来说：
     * 若个位大于0，1出现的次数为round*1+1
     * 若个位等于0，1出现的次数为round*1
     *
     * 对其它位来说，记每一位的权值为base，位值为weight，该位之前的数是former
     * 若weight为0，则1出现次数为round*base
     * 若weight为1，则1出现次数为round*base+former+1
     * 若weight大于1，则1出现次数为rount*base+base
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n<1){
            return 0;
        }
        int count=0;
        int base=1;
        int round=n;
        while (round>0){
            /**
             * weight表示这一位上面的数字
             * base表示这一位是哪一位
             */
            int weight=round%10;
            round=round/10;
            count+=round*base;
            if (weight==1){
                /**
                 * 这种情况就是这一位为1，count表示的是它的高位让它出现了多少次1，n%base表示的是
                 * 比如514的十位，5*10就是count，1就是14里面10的那个1，n%base就是14里面11 12 13 14里面的1
                 */
                count+=(n%base)+1;
            }else if (weight>1){
                /**
                 * 如果这一位是大于1的，说明这一位为1过，是需要增加一轮计算的
                 * 比如31，在上面把各位的1计算完后，十位上的3要次数要加10，就是从10到19的十个数字
                 */
                count+=base;
            }
            base*=10;
        }
        return count;
    }
}
