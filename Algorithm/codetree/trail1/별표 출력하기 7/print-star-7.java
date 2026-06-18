/*
    정수 N의 값을 입력받아 별표를 출력하는 프로그램

    *
    * *
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

        sc.close();
    }
}