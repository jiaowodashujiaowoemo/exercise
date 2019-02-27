package javaFoundation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author ChenXiang
 * @Date 2018/09/14,09:25
 */
public class staticInner {
    static void method1() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        System.out.println(listener.getClass());
        System.out.println(listener.getClass().getEnclosingClass());
    }

    public static void main(String[] args) {
        staticInner.method1();
        System.out.println(new staticInner().getClass());
    }
}
