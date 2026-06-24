// 100 이하의 정수 n을 입력받은 후, n부터 100까지의 숫자를 순서대로 출력하는 프로그램

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // n 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // n~100 공백 두고 출력
        for(int i=n; i<=100; i++)
            System.out.print(i + " ");
    }
}