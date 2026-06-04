// 자연수 N을 입력받아 while문을 사용하여 1부터 N까지 자연수를 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 출력
        int i = 1;
        while(i<=n) {
            System.out.print(i + " ");
            i++;
        }
    }
}