// A,B 두 자연수를 입력받아 B부터 A까지 1씩 감소하며 그 값을 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 출력
        for(int i=b; i>=a; i--){
            System.out.print(i + " ");
        }
    }
}