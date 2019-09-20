package LeetCode.链表中数字相加;

import java.util.List;
import java.util.Stack;

/**
 * Created by ChenXiang
 * 2019/09/12,11:59
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) 7243+564
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * 还有一种情况是个在前，这种情况更简单，直接遍历链表进行相加即可
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Main1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> stack1 = buildStack(l1);
        Stack<Integer> stack2 = buildStack(l2);
        int sum = 0;
        int carry = 0;
        int a = 0, b = 0;
        ListNode result= new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()||carry!=0) {
            a = stack1.isEmpty() ? 0 : stack1.pop();
            b = stack2.isEmpty() ? 0 : stack2.pop();
            sum = a + b + carry;
            carry = sum / 10;
            ListNode temp=new ListNode(sum%10);
            temp.next=result.next;
            result.next=temp;
        }
        return result.next;
    }

    public static Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
