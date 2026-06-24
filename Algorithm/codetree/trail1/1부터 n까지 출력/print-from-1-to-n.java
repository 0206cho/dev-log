// N을 입력받아, 1부터 N까지 공백을 두고 출력하는 프로그램
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // n 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1~n 정수 공백 출력
        for(int i=1; i<=n; i++){
            System.out.print(i + " ");
        }
    }
}