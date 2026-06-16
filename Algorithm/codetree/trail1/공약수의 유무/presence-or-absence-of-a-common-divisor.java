// 정수 A, B가 주어지면, A 이상 B 이하의 수 중에서 1920과 2880의 공약수가 존재하는지 판단해보는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        boolean ck = false;

        for(int i=a; i<=b; i++) {

            if( (1920%i==0) && (2880%i==0) ){
                ck = true;
            }

        }

        System.out.print(ck?"1":"0");

        sc.close();
    }
}