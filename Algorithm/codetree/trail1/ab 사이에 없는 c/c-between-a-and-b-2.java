// 정수 a,b가 주어지면, a이상 b이하에 c의 배수가 전혀 없는지 판단하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean ck = true;

        for(int i=a; i<=b; i++){
            if(i%c==0) {
                ck = false;
            }
        }

        System.out.println(ck?"YES":"NO");
        sc.close();
    }
}