// 두 정수 A와 B가 주어짐. 실수 A/B의 값을 소수점 21번째 자리에서 내림하여 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 출력
        System.out.print(a/b + ".");

        a %= b;
        for(int i=1; i<=20; i++){
            a*=10;
            System.out.print(a/b);
            a %= b;
        }
    }
}