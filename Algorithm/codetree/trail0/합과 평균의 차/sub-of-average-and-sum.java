// 세 개의 정수가 주어졌을 때, 세 정수의 합과 평균을 구하고, 합에서 평균을 뺀 값을 구하는 프로그램
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // a,b,c 공백 주고 입력
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int sum = a+b+c;
        int avg = sum/3;

        System.out.println(sum);        // 합
        System.out.println(avg);        // 평균
        System.out.println(sum-avg);    // 합 - 평균

    }
}