package 春招.头条.母牛生小牛;

/**
 * @Description 一头牛，三年才能生,10岁就死
 * https://blog.csdn.net/appleml/article/details/81316022
 * @Author ChenXiang
 * @Date 2019/04/27,10:23
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(fun(4));
    }

    public static int fun(int n){
        if (n==1||n==2){
            return 1;
        }else {
            if (n<=10){
                return fun(n-1)+fun(n-2);
            }else {
                return fun(n-1)+fun(n-2)-fun(n-10);
            }
        }
    }

}
