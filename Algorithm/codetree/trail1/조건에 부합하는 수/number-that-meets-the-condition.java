/*  
    정수 A 를 입력받아 1부터 A까지의 수 중 다음 조건 중 어떤 것도 만족하지 않는 수들을 모두 출력하는 프로그램

    # 조건
    - 짝수이면서 4의 배수가 아닌 수
    - 8로 나눈 몫이 짝수인 수
    - 7로 나눈 나머지가 4보다 작은 수
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        for(int i=1; i<=a; i++){
            if((i%2==0) && (i%4!=0))    // 짝수이면서 4의 배수가 아닌 수
                continue;
            if((i/8)%2==0)              // 8로 나눈 몫이 짝수인 수
                continue;
            if((i%7)<4)                 // 7로 나눈 나머지가 4보다 작은 수
                continue;
            // 출력
            System.out.print(i + " ");
        }
    }
}