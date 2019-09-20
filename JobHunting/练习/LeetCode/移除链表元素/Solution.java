package LeetCode.移除链表元素;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

/**
 * Created by ChenXiang
 * 2019/09/16,16:03
 */
public class Solution {

    //删除头结点时另作考虑
//    public ListNode removeElements(ListNode head, int val) {
//        //删除值相同的头结点后，可能新的头结点值也相等，用循环解决
//        while (head!=null&&head.val==val){
//            head=head.next;
//        }
//        if (head==null){
//            return head;
//        }
//        ListNode prev=head;
//        //确保当前节点后还有节点
//        while (prev.next!=null){
//            if (prev.next.val==val){
//                prev.next=prev.next .next;
//            }else {
//                prev=prev.next;
//            }
//        }
//        return head;
//    }

    //递归
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        if (head.val==val){
            return head.next;
        }else {
            return head;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
