package javaFoundation;

/**
 * @Description
 * @Author ChenXiang
 * @Date 2019/02/25,09:39
 */
class Value {
    int v;
    public Value(int v) {
        this.v = v;
    }
}

public class FinalTest {

    final int f1 = 1;
    final int f2;
    public FinalTest() {
        f2 = 2;
    }

    public static void main(String[] args) {
        final int  value1 = new Integer(2);
        System.out.println(value1);
        final double value2;
        value2 = 2.0;
        final Value value3 = new Value(1);
        value3.v = 4;
        System.out.println(value3);
    }
}