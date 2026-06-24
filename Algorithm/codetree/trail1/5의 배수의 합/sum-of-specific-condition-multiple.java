/*
    두 정수 A와 B가 주어짐
    A와 B를 포함하여, A와 B 사이의 수 중에서 5의 배수인 수를 모두 더한 값을 출력하는 프로그램
    
    A와 B 간에 대소 관계가 보장되지 않음
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sumVal = 0;

        int min = (a<b) ? a : b;
        int max = (a<b) ? b : a;

        for(int i =min; i<=max; i++) {
            if(i % 5 == 0) {
                sumVal+=i;
            }
        }

        // 출력
        System.out.print(sumVal);
    }
}