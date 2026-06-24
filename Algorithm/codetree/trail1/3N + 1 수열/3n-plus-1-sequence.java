/*
    자연수 N이 주어짐.
    아래 조건에 따라, N을 변경하여 최종적으로 1을 만들고자 함

    # 조건

    - N이 짝수인 경우, 2로 나눔
    - N이 홀수인 경우, 3을 곱하고 1을 더함
    - 총 몇 번을 반복해야, 1이 되는지 계산하는 프로그램

    ex) N=3 인 경우,
        3→10→5→16→8→4→2→1 순서로 1이 되므로 7
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        while(true) {
            if(n<=1){
                System.out.println(cnt);
                break;
            }

            if(n % 2 == 0) {
                n/=2;
            } else {
                n = n*3+1;
            }
            cnt++;
        }
    }
}