// 2의 거듭제곱수 중 하나인 N을 입력받아, N=2^x를 만족하는 x 값을 구하는 코드
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;

        while(n>1) {
            n/=2;
            cnt++;
        }

        System.out.println(cnt);
    }
}