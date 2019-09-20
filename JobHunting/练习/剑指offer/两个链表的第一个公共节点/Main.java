package 剑指offer.两个链表的第一个公共节点;

/**
 * Created by ChenXiang
 * 2019/09/14,21:24
 */
public class Main {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        //链表1的长度
        ListNode node1 = pHead1;
        int len1 = 1;
        while (node1.next != null) {
            node1 = node1.next;
            len1++;
        }
        //链表2的长度
        ListNode node2 = pHead2;
        int len2 = 1;
        while (node2.next != null) {
            node2 = node2.next;
            len2++;
        }
        //判断最后一个节点是否相同，不同则不相交
        if (node1 != node2) {
            return null;
        }
        ListNode longNode = pHead1;
        ListNode shortNode = pHead2;
        int diffLen = len1 - len2;
        if (len2 > len1) {
            longNode = pHead2;
            shortNode = pHead1;
            diffLen = len2 - len1;
        }
        for (int i = 0; i < diffLen; i++) {
            longNode = longNode.next;
        }
        while (longNode != shortNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return shortNode;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
