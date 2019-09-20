package 面试;

/**
 * Created by ChenXiang
 * 2019/08/30,11:24
 * 查找给定数字在有序数组中第一次和最后一次出现的位置
 */
public class Main1 {
    public static void main(String[] args) {
        getLastIdx(new int[]{1,2,3,3,3,5},3);
    }

    public static void getFirstIdx(int[] arr,int key){
        int fromIdx=0,endIdx=arr.length-1;
        while(fromIdx<endIdx){
            int mid=(fromIdx+endIdx)>>1;
            if(arr[mid]<key){
                fromIdx=mid+1;
            }else{
                endIdx=mid;
            }
        }
        if(arr[fromIdx]!=key){
            System.out.print(-1);
        }else{
            System.out.print(fromIdx);
        }
    }

    public static void getLastIdx(int[] arr,int key){
        int fromIdx=0,endIdx=arr.length-1;
        while(fromIdx<endIdx){
            int mid=(fromIdx+endIdx+1)>>1;//必须加1，否则会死循环，，而且必须先加1再除以2，否则跳多了，3和5中间是4，如果后加1，得到的是5
            if(arr[mid]>key){
                endIdx=mid-1;
            }else{
                fromIdx=mid;
            }
        }
        if(arr[endIdx]!=key){
            System.out.print(-1);
        }else{
            System.out.print(endIdx);
        }
    }
}
