// A,B가 주어졌을 때 A부터 B까지의 곱을 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int prod = 1;

        for(int i=a; i<=b; i++){
            prod *= i;
        }

        // 출력
        System.out.print(prod);
    }
}