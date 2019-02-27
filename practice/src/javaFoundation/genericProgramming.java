package javaFoundation;

/**
 * @Author ChenXiang
 * @Date 2018/09/19,20:43
 */
public class genericProgramming<T> {
    private T first;
    private T second;

    public genericProgramming(){

    }

    public genericProgramming(T o1,T o2){
        first = o1;
        second = o2;
    }


    public static void main(String[] args) {
        genericProgramming g = new genericProgramming();
//        List<String> stringList;
//        List<Integer> integerList;
//        if (stringList.getClass() == integerList.getClass())  true
//        Pair<String> table = new Pair<String> [10]; //error,擦除之后，table的类型是Pair[],可以转化为Object[]
//        Object[] objarray = table; //如果要赋值就会报错
//        objarray[0]  = "hello";
        genericProgramming<String> generic = g.makeGenericProgramming(String.class);
    }

    public static <T> genericProgramming<T> makeGenericProgramming(Class<T> c1) {
        try {
            return new genericProgramming<>(c1.newInstance(),c1.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}