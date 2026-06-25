/*
    정수 N의 값을 입력받아 별표를 출력하는 프로그램

    N에 2를 입력받는 경우
    * * *
      *

    N에 3을 입력받는 경우
    * * * * *
      * * *
        *
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=0; j<i*2; j++) {
                System.out.print(" ");
            }
            for(int j=0; j<(n - i) * 2 - 1; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
        sc.close();
    }
}
