package javaFoundation;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description final对象
 * @Author ChenXiang
 * @Date 2018/12/04,21:36
 */
public final class ImmutableObject {
    private final Set<String> stooges = new HashSet<String>();
    private final int i=0;
    private final BigInteger bigInteger= BigInteger.valueOf(2);
    private final BigInteger[] bigIntegers=new BigInteger[]{BigInteger.valueOf(1)};

    public ImmutableObject() {
        stooges.add("moe");
        stooges.add("larry");
        stooges.add("curly");
    }

    public static void main(String[] args) {
        ImmutableObject immutableObject = new ImmutableObject();
//        immutableObject.stooges=new HashSet<>();
//        immutableObject.i++;
        immutableObject.bigInteger.add(BigInteger.valueOf(1));
//        immutableObject.bigInteger=new BigInteger(String.valueOf(1));
//        immutableObject.bigIntegers=new BigInteger[]{BigInteger.valueOf(1)};
        immutableObject.bigIntegers[0].add(BigInteger.valueOf(1));
        immutableObject.stooges.add("eee");
        System.out.println(immutableObject.stooges.size());
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }
}