// A,B 두 자연수를 입력받아 A부터 B까지 짝수의 합을 구해 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sumVal = 0;

        for(int i=a; i<=b; i++) {
            if(i % 2 == 0) {
                sumVal+=i;
            }
        }

        // 출력
        System.out.print(sumVal);
    }
}