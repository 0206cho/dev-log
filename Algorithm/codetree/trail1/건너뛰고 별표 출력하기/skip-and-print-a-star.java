/*
    정수 N의 값을 입력받아 별표를 출력하는 프로그램을 아래 예를 참고하여 작성해보세요.

    N에 4를 입력받는 경우
    *

    **

    ***

    ****

    ***

    **

    *
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
            System.out.println("");
        }

        for(int i=n-1; i>=1; i--) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
            System.out.println("");
        }

        sc.close();
    }
}