/*
    정수 N이 주어졌을 때, 아래처럼 * 로 이루어진 N×N 크기의 정사각형을 두 개 출력
    
    **
    **

    **
    **
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("");

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        sc.close();
    }
}