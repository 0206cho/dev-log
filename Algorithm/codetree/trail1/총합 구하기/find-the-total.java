// 두 정수 A,B를 입력받고, A이상 B이하 수 중 
// 6의 배수이면서, 8의 배수가 아닌 수들의 합을 구하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = 0;

        for(int i=a; i<=b; i++) {
            if( (i % 6 == 0) && (i % 8 != 0)) {
                sum+=i;
            }
        }

        // 출력
        System.out.print(sum);
    }
}