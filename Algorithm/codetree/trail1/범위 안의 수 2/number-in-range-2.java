// 10개의 정수가 주어짐. 입력으로 주어지는 수들 중 0이상 200이하의 정수들의 합과 평균을 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum=0, cnt=0;

        for(int i=0; i<10; i++) {
            // 입력
            int tmp = sc.nextInt();

            if( (tmp >= 0) && (tmp <=200)) {
                sum+=tmp;
                cnt++;
            }
        }

        // 출력
        System.out.printf("%d %.1f", sum, (double)sum/cnt);
    }
}