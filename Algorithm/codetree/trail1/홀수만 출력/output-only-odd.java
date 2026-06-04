// 두 정수 A와 B가 주어지면 A이상 B이하의 홀수를 모두 오름차순으로 출력하는 프로그램

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 출력
        for(int i=a; i<=b; i++){
            if(i%2 == 1){
                System.out.print(i + " ");
            }
        }
    }
}