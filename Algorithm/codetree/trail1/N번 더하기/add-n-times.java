// 정수 A,N이 주어졌을 때, A에 N을 더하는 과정을 N번 반복. 각 연산 결과값을 순서대로 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();

        // 출력
        for(int i=0; i<n; i++){
            System.out.println(a+=n);
        }
    }
}