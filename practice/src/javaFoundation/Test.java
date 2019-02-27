package javaFoundation;

/**
 * @Description
 * @Author ChenXiang
 * @Date 2018/12/04,20:52
 */
public class Test {
    Integer integer = new Integer(1);
    Integer integer1 = new Integer(2);

    public void test(){
        integer=integer1;
        System.out.println(integer);
    }

    public static void main(String[] args) {
        new Test().test();

    }
}
