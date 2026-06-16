// 정수 N과 M의 값을 입력받아 별표로 이루어진 직사각형을 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

        sc.close();
    }
}