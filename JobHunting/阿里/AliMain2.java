import java.util.Scanner;


public class AliMain2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int idx=0;
        int longest=0;
        int k = sc.nextInt();
        for(int i = 0;i<s.length();i++){
            int count = 0 ;
            if(s.charAt(i)=='b'){
                int j = i+1;
                int l=i-1;
                if(j==s.length()){
                    j=0;
                }
                while(s.charAt(j)=='g'){
                    count++;
                    j++;
                    if(j==s.length()){
                        j=0;
                    }
                }
                if(l<0){
                    l=s.length()-1;
                }
                while(s.charAt(l)=='g'){
                    count++;
                    l--;
                    if(l<0){
                        l=s.length()-1;
                    }
                }
            }

            if(count>longest){
                idx=i;
            }
            longest=Math.max(longest,count);
        }
        int longest2 = 0;

        for(int i =0;i<s.length();i++){
            int c = 0;
            int d = 1;
            if(s.charAt(i)=='b'){
                int j=i+1;
                while(c<=k){
                    if(j==s.length()){
                        j=0;
                    }
                    if(s.charAt(j)=='g'){
                        c++;
                    }else if(s.charAt(j)=='b'){
                        d++;
                    }
                    j++;
                }

            }
            longest2 = Math.max(longest2,d);
        }
        System.out.print(idx+" "+longest2);
    }

}