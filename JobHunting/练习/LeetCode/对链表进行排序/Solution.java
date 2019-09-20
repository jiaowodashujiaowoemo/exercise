package LeetCode.对链表进行排序;

import javax.xml.stream.events.EndDocument;
import java.nio.file.NotLinkException;
import java.util.List;

/**
 * Created by ChenXiang
 * 2019/09/16,17:09
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre=head;  //pre指向已经有序的最后一个节点
        ListNode cur=head.next; //指向待排序的节点

        ListNode aux=new ListNode(-1);
        aux.next=head;

        while (cur!=null){
            if (cur.val<pre.val){
                //先把cur节点从当前链表中删除，然后再把cur节点插入到合适位置
                pre.next=cur.next;
                //从前往后找到l2.val>cur.val，然后把cur节点插入到l1和l2之间
                ListNode l1=aux;
                ListNode l2=aux.next;
                while (cur.val>l2.val){
                    l1=l2;
                    l2=l2.next;
                }
                //找到合适的位置之后，把cur插入到l1和l2之间
                l1.next=cur;
                cur.next=l2;

                //指向下一个待处理节点
                cur=pre.next;
            }else {
                //如果cur大于之前的节点，直接后移
                pre=cur;
                cur=cur.next;
            }
        }
        return aux.next;
    }

    public ListNode quickSortList(ListNode head,ListNode tail){
        //判断是否为空，是否只有一个节点
        if (head==null|| tail==null||head==tail){
            return head;
        }
        //从第一个节点和第一个节点的后面一个节点
        //head指向的是当前遍历到的最后一个<=nMidValue的节点
        ListNode first=head;
        ListNode second=head.next;

        int key=head.val;
        //结束条件，second到最后了
        while (second!=tail.next&&second!=null){
            //一直向后寻找<=key，然后与first的后继节点交换
            if(second.val<key){
                first=first.next;
                //判断一下，避免后面的数比第一个数小，不用交换的情况
                if (first!=second){
                    int temp=first.val;
                    first.val=second.val;
                    second.val=temp;
                }
            }
            //如果要排序的节点比前面的大，就继续向后找下一个待排序的节点
            second=second.next;
        }
        //如果相等就是key右边的都比它大，它的位置已经确定
        if (head!=first){
            int temp=head.val;
            head.val=first.val;
            first.val=temp;
        }
        quickSortList(head,first);
        quickSortList(first.next,tail);
        return first;
    }

    public ListNode mergeSortList(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        //获取中间节点
        ListNode mid=getMid(head);
        ListNode right=mid.next;
        mid.next=null;

        //合并
        return mergeSort(mergeSortList(head),mergeSortList(right));
    }

    private ListNode mergeSort(ListNode left, ListNode right) {
        ListNode head=new ListNode(-1);
        ListNode tail= head;    //tail指向最后一个排好序的节点
        while (left!=null&&right!=null){
            if (left.val<=right.val){
                tail.next=left;
                left=left.next;
            }else {
                tail.next=right;
                right=right.next;
            }
            tail=tail.next;
        }
        if (left!=null){
            tail.next=left;
        }
        if (right!=null){
            tail.next=right;
        }
        return head.next;
    }

    public ListNode getMid(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode quick=head.next;
        while (quick!=null&&quick.next!=null){
            slow=slow.next;
            quick=quick.next.next;
        }
        /**
         * 注意快慢指针的两种写法，两个指针的初始位置不同，判断条件也不同，但是实质都是一样的，判断下一个节点和下下一个节点是否为空，记住这一点就行
         * //快慢指针
         * ListNode slow = head, quick = head;
         * //快2步，慢一步
         * while (quick.next != null && quick.next.next != null) {
         *     slow = slow.next;
         *     quick = quick.next.next;
         * }
         */
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
