// 5개의 정수가 주어졌을 때, 주어진 모든 수가 3의 배수인지 판단하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        
        for(int i=0; i<5; i++) {
            int num = sc.nextInt();

            if(num%3==0) {
                cnt++;
            }
        }

        System.out.print((cnt==5)?"1":"0");
        
        sc.close();
    }
}