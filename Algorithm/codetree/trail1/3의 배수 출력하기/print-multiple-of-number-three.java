// while문을 사용해 1부터 정수 N까지의 3의 배수를 모두 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 변수선언
        int n, i = 1;

        // 입력
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 출력
        while( (i*3) <= n) {
            System.out.print( (i*3) + " ");
            i++;
        }
    }
}