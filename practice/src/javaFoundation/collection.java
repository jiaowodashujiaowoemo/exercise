package javaFoundation;

import java.util.*;

/**
 * @Author ChenXiang
 * @Date 2018/11/07,14:31
 */
public class collection {
    public static void main(String[] args) {
        List<String> staff = new LinkedList<>();
        staff.add("A");
        staff.add("B");
        staff.add("C");
        ListIterator<String> iterator = staff.listIterator();
        iterator.next();
        /**
         * 迭代器是在当前位置之前添加元素
         * remove()删除的是迭代器越过的元素
         */
        iterator.add("J");
        iterator.next();
        iterator.remove();
        iterator.previous();
        iterator.remove();
        /**
         * 不使用迭代器就是在头尾进行添加和删除操作
         */
        staff.add("D");
        staff.add("E");
        ((LinkedList<String>) staff).remove();
        ((LinkedList<String>) staff).remove();
        System.out.println(staff);

//        Iterator iterator1 = staff.iterator();
//
//        int[] a =new int[4];
//        a[0]=1;
//        int[] b=a.clone();
//        System.out.println(b[0]);

    }
}
