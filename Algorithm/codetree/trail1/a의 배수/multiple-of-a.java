/*
    두 정수 N, a가 순서대로 주어지면, while문을 사용해 1부터 N까지의 정수를 순서대로 확인하여 
    해당 수가 a의 배수이면 1을, 아니면 0을 한 줄에 하나씩 출력하는 프로그램
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();

        int i =0;

        // 출력
        while(i<n) {
            i++;
            if(i % a == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}