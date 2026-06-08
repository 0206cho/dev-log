// 두 정수 A와 B를 입력받아, A가 양수라면 A를 B번 반복하여 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 출력
        if( a > 0 ){
            for(int i=0; i<b; i++){
                System.out.print(a);
            }
        } else {
            System.out.print(0);
        }
    }
}