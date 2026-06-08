/* 문자 C와 숫자 N을 입력받아, 만약 C가 'A'이면 1부터 N까지 숫자를 증가하는 순으로 출력하고, 
'D'이면 N부터 1까지 숫자를 감소하는 순으로 출력하는 프로그램*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        int n = sc.nextInt();

        // 출력
        if(c == 'A') {
            for(int i=1; i<=n; i++) {
                System.out.print(i + " ");
            }
        } else { 
            for(int i=n; i>=1; i--) {
                System.out.print(i + " ");
            }
        }
    }
}