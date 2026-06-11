/*
    1이상 N이하의 정수 중 온전수를 모두 출력하는 프로그램을 작성해보세요.

    # 온전수 : 아래 조건 중 어떠한 것도 만족하지 않는 수
    - 2로 나누어 떨어진다.
    - 일의 자리 숫자가 5이다.
    - 3으로 나누어 떨어지면서 9로는 나누어 떨어지지 않는다.
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            if( (i%2==0) || ( (i%3==0) && (i%9!=0) )|| (i%10==5)){
                continue;
            }
            // 출력
            System.out.print(i + " ");
        }
    }
}