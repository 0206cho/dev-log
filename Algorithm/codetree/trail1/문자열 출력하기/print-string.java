// 정수 N의 값을 입력받고 그 값의 횟수만큼 LeebrosCode를 출력하는 프로그램을 작성
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 출력
        for(int i=0; i<n; i++){
            System.out.println("LeebrosCode");
        }
    }
}