/*
    정수 N이 주어졌을 때, N을 차례대로 1, 2, 3, … 으로 나누었을 때 
    1 이하가 되는 순간까지 나눗셈을 진행한 총 횟수를 구하는 프로그램

    단, 나눗셈 진행시 각 나눗셈 연산에서 몫을 저장
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int temp = n;

        for(int i=1; i<=n; i++) {
            temp/=i;
            if(temp <= 1){
                // 출력
                System.out.print(i);
                break;
            }
        }
    }
}