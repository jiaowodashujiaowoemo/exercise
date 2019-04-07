package 剑指offer.倒排链表;

import java.util.ArrayList;

/**
 * @Description 按链表值从尾到头的顺序返回一个ArrayList
 * @Author ChenXiang
 * @Date 2019/03/31,19:38
 */
public class Main {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list=new ArrayList<>();
        if (null!=listNode){
            if (null!=listNode.next){
                list.addAll(printListFromTailToHead(listNode.next));
            }
            list.add(listNode.val);//从最后一个节点开始，每次向上层返回的时候就把当前节点的值加进去
        }
        return list;
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}
