/*
    정수 N이 주어졌을 때, * 로 이루어진 직각삼각형을 출력하는 프로그램

    N=3 일 때
    *
    ***
    *****

    N=5 일 때
    *
    ***
    *****
    *******
    *********
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=(i*2-1); j++){
                System.out.print("*");
            }
            System.out.println("");
        }

        sc.close();
    }
}