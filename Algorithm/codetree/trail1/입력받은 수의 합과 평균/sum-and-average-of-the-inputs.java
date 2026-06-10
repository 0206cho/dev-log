// 자연수 N을 입력받고, N개의 정수를 입력받아 합계와 평균을 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 0;

        for(int i=0; i<n; i++){
            // 입력 (2)
            int num = sc.nextInt();
            sum += num;
        }

        // 출력
        System.out.printf("%d %.1f", sum, (double)sum / n);
    }
}