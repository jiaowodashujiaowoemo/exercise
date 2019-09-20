package 剑指offer.数字在排序树组中出现的次数;

/**
 * Created by ChenXiang
 * 2019/09/14,21:33
 * 最后一次出现的位置减去第一次出现的位置 +1
 */
public class Main {
    public int GetNumberOfK(int [] array , int k) {
        if (array==null||array.length==0){
            return 0;
        }
        int first=getFirstIdx(array,k);
        int last=getLastIdx(array,k);
        if (first>-1&&last>-1){
            return last-first+1;
        }else {
            return 0;
        }
    }

    public static int getFirstIdx(int[] arr,int key){
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
            return -1;
        }else{
            return fromIdx;
        }
    }

    public static int getLastIdx(int[] arr,int key){
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
            return -1;
        }else{
            return endIdx;
        }
    }

}
