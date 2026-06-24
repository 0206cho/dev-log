// 정수 N이 주어지면 *을 N개의 줄에 걸쳐 한 줄에 하나씩 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 출력
        int i = 1;
        while(i<=n) {
            System.out.println("*");
            i++;
        }

    }
}