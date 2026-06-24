// 정수 A,B이 주어졌을 때, A부터 B까지의 자연수중 짝수만 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 변수 선언
        int a, b;

        // 입력
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        // 출력
        while(a <= b) {
            System.out.print(a + " ");
            a += 2;
        }
    }
}