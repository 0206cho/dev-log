/*
    N이 주어지면 1년부터 N년까지 윤년이 총 몇 번 있었는지를 구하는 프로그램
    
    # 윤년의 조건
    - 4로 나누어 떨어지는 해는 윤년, 그 밖의 해는 평년
    - 단, 예외적으로 100으로 나누어 떨어지되 400으로 나누어 떨어지지 않는 해는 평년
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;

        for(int i=1; i<=n; i++){
            if(i % 4 == 0){
                if(!((i % 100 == 0) && (i % 400 != 0))){
                    cnt++;
                }
            } 
        }

        // 출력
        System.out.print(cnt);
    }
}