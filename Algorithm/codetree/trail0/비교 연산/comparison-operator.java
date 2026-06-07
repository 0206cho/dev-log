// 두 정수 A,B를 입력받아 다음 조건들이 각각 참인지 거짓인지를 판단하는 프로그램
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 출력
        if(a>=b){   // a가 b보다 같거나 큰지
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        if(a>b){    // a가 b보다 큰지
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        if(a<=b){   // b가 a보자 같거나 큰지
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        if(a<b){    // b가 a보자 큰지
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        if(a==b){   // a와 b가 같은지
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        if(a!=b){   // a와 b가 다른지
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}