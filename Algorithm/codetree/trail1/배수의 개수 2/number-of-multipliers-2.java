// 10개의 수 중 홀수의 개수를 출력하는 프로그램을 작성
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        
        int sum = 0;
        
        for(int i =0; i<10; i++){
            int num = sc.nextInt();

            if(num % 2 == 1){
                sum++;
            }
        }

        // 출력
        System.out.println(sum);
    }
}