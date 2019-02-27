package javaFoundation;

/**
 * @Description
 * @Author ChenXiang
 * @Date 2018/12/11,09:36
 */
public class inherit {
    public static void main(String[] args) {
        Parent parent = new Child();
        System.out.println(parent);
//        System.out.println(((Child) parent).string);
//        System.out.println(parent.childStr);
//        ((Child)parent).print(" ");
    }
}

class Parent{
    public String string = "parent";
    public void print(){
        System.out.println("parent");
    }
}

class Child extends Parent{
    public String string = "child";
    public String childStr = "childString";

    public void print(String string){
        System.out.println("child");
    }
}
