import java.util.HashMap;
import java.util.Map;

public class Main{
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap<>();
        int[] result=new int[];
        for(int i=0;i<nums.length;i++){
            int x=target-nums[i];
            if (map.containsKey(x)){
                result=new int[]{map.get(x),i};
            }
            map.put(nums[i],i);
        }
        return result;
//        throw new IllegalArgumentException("无解");

    }
}