// 정수 N이 주어졌을 때, 1부터 차례대로 100까지 1씩 증가시키며 합을 구하다가 
// 처음으로 그 합이 N 이상이 되는 순간에 더해진 수가 무엇인지를 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 0;

        for(int i=1; i<=100; i++) {
            sum+=i;
            if(sum >= n)  {
                // 출력
                System.out.print(i);
                break;
            }
        }
    }
}