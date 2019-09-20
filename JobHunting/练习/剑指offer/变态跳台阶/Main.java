package 剑指offer.变态跳台阶;

/**
 * Created by ChenXiang
 * 2019/09/14,21:52
 * 可以用归纳法证明f(n)=2^(n-1)
 */
public class Main {
    public int JumpFloorII(int target) {
        if (target==1||target==0){
            return 1;
        }
        int result=1;
        for (int i=0;i<target-1;i++){
            result*=2;
        }
        return result;
    }
}
