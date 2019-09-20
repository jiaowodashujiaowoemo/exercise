package LeetCode.验证栈序列;

import java.util.Stack;

/**
 * Created by ChenXiang
 * 2019/09/16,16:17
 * <p>
 * 给定 pushed 和 popped 两个序列，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false
 * 栈中数字不重复
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null | popped == null || pushed.length != popped.length) {
            return false;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            //这里注意两个条件的先后顺序
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        if (pushed==null||popped==null||pushed.length!=popped.length){
//            return false;
//        }
//        Stack<Integer> stack=new Stack<>();
//        //j指向要入栈的位置
//        int j=0;
//        for (int i=0;i<popped.length;i++){
//            //栈为空或者栈顶元素不等于下一个弹出元素时，压栈
//            while (stack.isEmpty()||stack.peek()!=popped[i]){
//                //判断元素是否已经全部入栈
//                if (j>=pushed.length){
//                    break;
//                }
//                stack.push(pushed[j]);
//                j++;
//            }
//            //元素已经全部入栈
//            if(stack.peek()!=popped[i]){
//                return false;
//            }
//            //如果栈顶和下一个出·弹出元素相等，直接到这一步
//            stack.pop();
//        }
//        if (stack.isEmpty()){
//            return true;
//        }
//        return false;
//    }
}
