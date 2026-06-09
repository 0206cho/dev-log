/*
    정수 A부터 B까지 숫자를 출력하는 프로그램
    A에서 시작하여 조건에 맞춰 수를 변경하다 B보다 커지는 순간에 종료. 
    
    # 수가 바뀌는 조건
    - 수가 홀수인 경우에는 2배가 됩니다.
    - 수가 짝수인 경우에는 3만큼 증가합니다.
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력 
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 출력
        for(int i = a; a<=b; i++){
            System.out.print(a + " ");
            if(i % 2 == 0){
                a+=3;
            } else {
                a*=2;
            }
        }
    }
}