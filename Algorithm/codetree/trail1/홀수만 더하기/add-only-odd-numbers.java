// N 개의 정수가 주어질 때, 이 중 홀수이면서 동시에 3의 배수인 수들의 총합을 구하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sumVal = 0;

        for(int i=0; i<n; i++){
            // 입력 (2)
            int num = sc.nextInt();
            if( (num % 2 == 1) && (num % 3 == 0)) {
                sumVal+=num;
            }
        }
        // 출력
        System.out.print(sumVal);
    }
}