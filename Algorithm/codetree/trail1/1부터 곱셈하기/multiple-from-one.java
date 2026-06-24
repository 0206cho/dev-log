/*
    N이 주어졌을 때, 1부터 차례대로 10까지 1씩 증가시키며 그 수들의 곱을 구함

    수들의 곱이 처음으로 N 이상이 되는 순간 
    마지막으로 곱해진 수가 무엇인지를 출력하는 프로그램
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int prod = 1;

        for(int i=1; i<=10; i++) {
            prod*=i;
            
            if(prod>=n) {
                // 출력
                System.out.print(i);
                break;
            }
        }
    }
}