/*
    정수 N의 값을 입력받아 별표를 출력하는 프로그램

    N에 3를 입력받는 경우
        *
      * * *
    * * * * *
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            for(int j=n-1; j>i-1; j--) {
                System.out.print("  ");
            }

            for(int j=1; j<=2*i-1; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
        sc.close();
    }
}