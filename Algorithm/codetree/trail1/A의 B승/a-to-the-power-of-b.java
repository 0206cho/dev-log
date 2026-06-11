// A,B 두 자연수를 입력받아 A^B 값을 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int prod = 1;
        for(int i=1; i<=b; i++) {
            prod *=a;
        }

        // 출력
        System.out.print(prod);
    }
}