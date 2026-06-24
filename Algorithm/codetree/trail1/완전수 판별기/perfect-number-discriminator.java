/*
    정수 N이 주어졌을 때, N이 완전수인지 판단하는 프로그램
    
    완전수 : 자기 자신을 제외한 약수의 합이 자신이 되는 수  
    ex) 6의 경우 1+2+3=6 이기 때문에 완전수
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 

        int sum = 0;

        for(int i=1; i<=n/2; i++){
            if(n % i == 0) {
                sum+=i;
            }
        }

        // 출력
        System.out.print( (sum == n) ? "P" : "N");
    }
}