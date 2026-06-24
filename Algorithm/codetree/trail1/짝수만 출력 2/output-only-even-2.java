// 두 정수 B와 A가 주어지면 A이상 B이하의 짝수를 모두 내림차순으로 출력하는 프로그램을 작성
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int a = sc.nextInt();

        // 출력
        while(b >= a){
            System.out.print(b + " ");
            b -= 2;
        }
    }
}