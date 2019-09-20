import java.util.Scanner;

/**
 * Created by ChenXiang
 * 2019/09/01,20:02
 */
public class Maint1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
//        List<Integer> boxJ=new ArrayList<>();
//        List<Integer> boxO=new ArrayList<>();
//        List<Integer> keyJ=new ArrayList<>();
//        List<Integer> keyO=new ArrayList<>();
        int keyJ=0,keyO=0,boxJ=0,boxO=0;
        for (int i=0;i<n;i++){
            int x=scanner.nextInt();
            if (x%2==0){
                boxO++;
//                boxO.add(x);
            }else{
                boxJ++;
//                boxJ.add(x);
            }
        }
        for (int i=0;i<m;i++){
            int x=scanner.nextInt();
            if (x%2==0){
                keyO++;
//                keyO.add(x);
            }else {
                keyJ++;
//                keyJ.add(x);
            }
        }

        System.out.println(Math.min(boxJ,keyO)+Math.min(boxO,keyJ));


    }
}
