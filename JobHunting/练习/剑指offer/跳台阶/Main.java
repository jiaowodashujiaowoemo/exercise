package 剑指offer.跳台阶;

/**
 * Created by ChenXiang
 * 2019/09/14,22:02
 */
public class Main {
    public int JumpFloor(int target) {
        if (target<=2){
            return target;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
