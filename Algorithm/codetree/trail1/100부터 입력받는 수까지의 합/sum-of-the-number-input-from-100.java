// 100 이하의 정수 N을 입력받은 후, N부터 100까지의 합을 구하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 0;

        for(int i=n; i<=100; i++){
            sum+=i;
        }

        // 출력
        System.out.print(sum);
    }
}