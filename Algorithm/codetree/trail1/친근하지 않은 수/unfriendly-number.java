// 1이상 N이하의 정수 중 친근하지 않은 수의 개수를 출력하는 프로그램
// 친근한 수 : 2, 3 또는 5로 나누어 떨어지는 수
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;

        for(int i=1; i<=n; i++) {
            if( (i%2==0) || (i%3==0) || (i%5==0)){
                continue;
            }

            cnt++;
        }

        // 출력
        System.out.print(cnt);
    }
}