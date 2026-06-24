/* 1부터 N까지의 정수를 순서대로 확인하여 해당 수가 2의 배수거나 3의 배수이면 1을, 
아니면 0을 각각 공백을 사이에 두고 출력하는 프로그램 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 출력
        for(int i=0; i<n; i++) {
            if( ((i+1) % 2 ==0) || ((i+1) % 3 ==0) ) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}