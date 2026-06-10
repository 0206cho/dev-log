// 5개의 수가 주어졌을 때, 짝수가 몇 번 등장했는지 확인해보는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        for(int i=0; i<5; i++){
            // 입력
            int tmp = sc.nextInt();
            if(tmp % 2 ==0){
                cnt++;
            }
        }

        // 출력
        System.out.print(cnt);
    }
}