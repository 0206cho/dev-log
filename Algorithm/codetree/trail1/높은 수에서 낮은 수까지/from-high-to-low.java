// 두 개의 정수 A,B를 입력받아 큰 수부터 작은 수까지 차례대로 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int max, min;

        // 연산
        if(a > b){
            max=a;
            min=b;            
        } else {
            max=b;
            min=a;
        }

        // 계산
        for(int i=max; i>=min; i--){
            System.out.print(i + " ");
        }
    }
}