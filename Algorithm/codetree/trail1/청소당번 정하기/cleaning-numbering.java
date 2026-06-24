/*
    0일을 기점으로 2일마다 교실 청소를, 3일마다 복도 청소를, 12일마다 화장실 청소
    날짜가 겹치는 날에는 주기가 더 긴 것을 함
    n일간 진행했을 때 각 장소의 청소 횟수를 차례로 출력하는 프로그램
    시작 날인 0일에는 청소를 진행하지 않습니다.
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt1 = 0;   // 교실
        int cnt2 = 0;   // 복도
        int cnt3 = 0;   // 화장실

        for(int i=1; i<=n; i++) {
            // 주기가 긴 순서
             if(i % 12 == 0){
                cnt3++;
            } else if(i % 3 == 0){
                cnt2++;
            } else if(i % 2 == 0){
                cnt1++;
            }
        }

        // 출력
        System.out.print(cnt1 + " " + cnt2 + " " + cnt3);
    }
}