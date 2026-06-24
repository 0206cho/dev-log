/*
    정수 N의 값에 따라 다음과 같은 연산을 진행할 때, cnt 번의 연산을 했을 때 처음으로 1000 이상이 된다고 함
    cnt의 값을 구해보는 프로그램

    - N이 짝수일 때, N에 3을 곱하고 1을 더함
    - N이 홀수일 때, N에 2를 곱하고 2를 더함
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;

        while(true) {
            if(n>=1000) {
                System.out.println(cnt);
                break;
            }
            if(n % 2 == 0) {
                n = n*3+1;
            } else {
                n = n*2+2;
            }
            cnt++;
        }
    }
}