// 두 정수 B와 A가 주어지고, B 이하 A 이상의 모든 홀수를 내림차순으로 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int a = sc.nextInt();

        // 출력
        for(int i=b; i>=a; i-=2){
            System.out.print(i + " ");
        }
    }
}