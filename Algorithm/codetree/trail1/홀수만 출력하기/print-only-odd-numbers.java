// N개의 정수가 주어졌을 때, 주어진 수 중 홀수이면서 3의 배수인 수들만 순서대로 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];

        for(int i = 0; i<n; i++){
            // 입력 (2)
            num[i] = sc.nextInt();

            // 출력
            if( (num[i] % 2 == 1) && num[i] % 3 == 0){
                System.out.println(num[i]);
            }
        }
    }
}