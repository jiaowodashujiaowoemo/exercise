package javaFoundation;

import java.util.*;

/**
 * @Description
 * @Author ChenXiang
 * @Date 2018/12/04,20:52
 */
public class Test {
    Integer integer = new Integer(1);
    Integer integer1 = new Integer(2);

    static int i=-2>>>33;
    static int n=-2>>>1;
    public void test(){
        integer=integer1;
        System.out.println(integer);
    }

    public static void main(String[] args) {
//        new Test().test();
//        System.out.println(i);
//        System.out.println(n);

//        Integer x = 127;
//        Integer y = 127;
//        System.out.println(x == y);// true
//        System.out.println(x.equals(y));//true
//        Integer a = new Integer(127);
//        Integer b = new Integer(127);
//        System.out.println(a == b);//false
//        System.out.println(a.equals(b));//true
//
//        Integer c = 128;
//        Integer d = 128;
//        System.out.println(c == d);// false
//        System.out.println(c.equals(d));//true
//        Integer e = new Integer(128);
//        Integer f = new Integer(128);
//        System.out.println(e == f);//false
//        System.out.println(e.equals(f));//true
        System.out.println(3*0.1==0.3);
    }
}
