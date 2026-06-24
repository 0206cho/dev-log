/* 
    자연수 N을 입력받아 1부터 N까지 369 게임을 진행했을 때의 결과를 출력하는 프로그램

    수가 3의 배수이거나 수를 구성하는 숫자에 3, 6, 9 중 하나라도 들어가있는 경우에는 0을 출력, 
    그렇지 않다면 해당 수를 그대로 출력
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // 출력
        for(int i=1; i<=n; i++){
            String tmp = String.valueOf(i);

            if(tmp.contains("3") || tmp.contains("6") || tmp.contains("9") || (i % 3 ==0)) {
                System.out.print(0 + " ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}