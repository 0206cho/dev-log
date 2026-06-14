/*
    정수 25를 맞히는 게임
    : 주어지는 정수값이 25보다 작으면 Higher를, 25보다 크면 Lower를 출력하는 작업을 반복
    25가 주어지면 Good을 출력하고 중단하는 프로그램
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            // 입력
            int n = sc.nextInt();

            // 출력
            if (25>n) {
                System.out.println("Higher");
            } else if (25<n) {
                System.out.println("Lower");
            } else {
                System.out.println("Good");
                break;
            }
        }
    }
}