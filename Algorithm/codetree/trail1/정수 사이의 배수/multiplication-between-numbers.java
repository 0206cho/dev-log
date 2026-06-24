// 두 개의 정수 A, B를 입력받아 A부터 B까지의 수 중 5 또는 7의 배수들의 합과 평균을 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = 0, cnt = 0;

        for(int i=a; i<=b; i++){
            if( (i % 5 == 0) || (i % 7 == 0)) {
                sum+=i;
                cnt++;
            }
        }
        
        // 출력
        System.out.printf("%d %.1f", sum, (double)sum/cnt);
    }
}