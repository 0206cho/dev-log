// 10개의 수가 주어졌을 때, 3의 배수의 개수와 5의 배수의 개수를 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);

        int cntThree = 0;
        int cntFive = 0;
        int i = 0;

        while(i<10){
            // 입력 (2)
            int num = sc.nextInt();

            if(num % 3 == 0){
                cntThree++;
            } 
            if(num % 5 == 0){
                cntFive++;
            }
            i++;
        }

        // 출력
        System.out.print(cntThree + " " + cntFive);
    }
}