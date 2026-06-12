// 정수를 계속 입력받다가 0이 입력되기 전까지의 결과를 그대로 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            // 입력
            int n = sc.nextInt();
            
            if(n == 0) {
                break;
            }
            
            // 출력
            System.out.println(n);
        }
    }
}