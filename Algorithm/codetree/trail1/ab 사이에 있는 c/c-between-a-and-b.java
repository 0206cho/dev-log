// 정수 a,b가 주어지면, a이상 b이하에 c의 배수가 단 하나라도 있는지 판단하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean check = false;
        
        for(int i=a; i<=b; i++) {
            if(i%c==0) {
                check = true;
            }
        }

        System.out.println(check?"YES":"NO");

    }
}