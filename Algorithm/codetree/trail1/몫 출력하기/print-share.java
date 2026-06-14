/* 
    어떤 수가 주어졌을 때 홀수면 아무 작업도 하지 않고, 
    짝수면 2로 나눈 몫을 출력하는 작업을 3번까지 반복하는 프로그램
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int cnt = 3;

        while(cnt > 0) {
            // 입력
            int n = sc.nextInt();

            if(n % 2 == 0) {
                // 출력
                System.out.println(n/2);
                cnt--;
            }
        }

        sc.close();
    }
}