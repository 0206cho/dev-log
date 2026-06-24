/*
    두 정수 A, B를 입력받아 다음 두 값을 공백으로 구분해 한 줄에 출력하는 프로그램

    첫 번째 값: A가 B보다 작으면 1, 아니면 0
    두 번째 값: A와 B가 같으면 1, 아니면 0
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(a<b?1:0);
        System.out.print(" ");
        System.out.print(a==b?1:0);
    }
}