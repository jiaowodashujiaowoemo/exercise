package javaFoundation;

/**
 * @Author ChenXiang
 * @Date 2018/11/07,09:32
 * 在写微众的代码，发现实际调用的构造方法跟我想要的不一样，可能是因为参数列表中的null位置不对
 *
 * 额，，.没错啊，ranger的代码怎么回事啊
 */

/**
 * 垃圾，自己搞错了
 */
public class paramsWithNull {
    String para1;
    String para2;
    String para3;
    public paramsWithNull(String para3){
        this(null,para3);
    }
    public paramsWithNull(String para1,String para2){
        this(para1,null,para2);
    }

    public paramsWithNull(String para1,String para2,String para3){
        this.para1=para1;
        this.para2=para2;
        this.para3=para3;
    }

    public void sout() {
        System.out.println("para1:"+para1);
        System.out.println("para2:"+para2);
        System.out.println("para3:"+para3);
    }

    public static void main(String[] args) {
        paramsWithNull paramsWithNull = new paramsWithNull("para1",null,"para3");
        paramsWithNull.sout();
    }
}
