// 두 정수 A와 B가 주어졌을 때, 1부터 B까지의 수 중 A의 배수들의 곱을 구하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int prod = 1;

        for(int i=1; i<=b; i++) {
            if(i % a == 0){
                prod *= i;
            }
        }

        // 출력
        System.out.print(prod);
    }
}