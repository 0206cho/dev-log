/*
    정수 N의 값을 입력받아 별표를 출력하는 프로그램
   
    N에 2를 입력받는 경우
    ** **
    *

    N에 3을 입력받는 경우
    *** *** ***
    ** ** 
    *
*/
import java.util.Scanner;
public class Main {
    public static void fn_star(int n, int a){
        // 별 출력
        for(int i=0; i<a; i++) {
            for(int j=0; j<a; j++) {
                System.out.print("*");
            }
            System.out.print(" ");    
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=n; i>0; i--){
            // 별 개수, 출력할 별의 묶음 수
            fn_star(n, i);
            System.out.println(" ");
        }

        sc.close();
    }
}