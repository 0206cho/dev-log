// 문자를 입력받아서 8회 출력하는 프로그램을 작성
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);

        // 출력
        for(int i=1; i<=8; i++){
            System.out.print(c);
        }
    }
}