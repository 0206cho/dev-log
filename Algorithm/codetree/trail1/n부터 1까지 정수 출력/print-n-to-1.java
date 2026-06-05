// 자연수 n을 입력받아 while문을 사용하여 n부터 1까지 정수를 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 출력
        while(n >= 1) {
            System.out.print(n + " ");
            n--;
        }
    }
}