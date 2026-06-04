// 정수 N의 값을 입력받아 1까지 차례로 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 출력
        for(int i=n; i>=1; i--){
            System.out.print(i + " ");
        }
    }
}