package LeetCode.两个排位数组的中位数.无序数组的中位数;

import javafx.beans.binding.DoubleExpression;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.EmptyStackException;
import java.util.PriorityQueue;

/**
 * Created by ChenXiang
 * 2019/09/06,16:20
 * 如果数组无序，要求中位数需要设置一个小顶堆
 * 使用数组的前(N+1)/2个元素建堆
 */
public class Main {
    public static double median(int[] array){
        int heapSize=array.length/2+1;
        PriorityQueue<Integer> heap=new PriorityQueue<>(heapSize);
        for (int i=0;i<heapSize;i++){
            heap.add(array[i]);
        }

        for (int i=heapSize;i<array.length;i++){
            if (heap.peek()<array[i]){
                heap.poll();
                heap.add(array[i]);
            }
        }

        if (array.length%2==1){
            return (double)heap.peek();
        }else {
            return (heap.poll()+heap.peek())/2.0;
        }
    }

}