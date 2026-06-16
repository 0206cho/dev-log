// 소수는 1보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수
// 자연수 N이 주어졌을 때, N이 소수인지 판단하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean ck = true;

        for(int i=2; i<n; i++){
            if(n%i == 0) {
                ck = false;
            }
        }

        System.out.print(ck?"P":"C");
        sc.close();
    }
}