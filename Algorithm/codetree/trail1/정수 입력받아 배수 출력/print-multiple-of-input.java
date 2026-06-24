// 자연수 N을 입력받아 N보다 크거나 같은 N의 배수 중 작은 수 5개를 차례로 출력
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=5; i++){
            System.out.print( n*i + " ");
        }
    }
}