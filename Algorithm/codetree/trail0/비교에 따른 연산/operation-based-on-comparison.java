/*
    두 개의 정수 a, b를 입력받아 a가 b보다 크다면 두 수의 곱을 출력하고, 
    그렇지 않다면 b를 a로 나눈 몫을 출력하는 프로그램
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a>b) {
            System.out.println(a*b);
        } else {
            System.out.println(b/a);
        }

        sc.close();
    }
}