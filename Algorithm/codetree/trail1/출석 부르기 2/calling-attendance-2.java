/*
    A반의 출석번호 1번은 John, 2번은 Tom, 3번은 Paul, 4번은 Sam
    번호를 입력하면 해당하는 학생의 이름을 출력하는 작업을 반복하다가 해당하는 번호 이외의 수가 입력되면 
    Vacancy를 출력하고 종료하는 프로그램
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            // 입력
            int n = sc.nextInt();

            // 출력
            if(n ==1)
                System.out.println("John");
            else if(n ==2)
                System.out.println("Tom");
            else if(n ==3)
                System.out.println("Paul");
            else if(n ==4)
                System.out.println("Sam");
            else {
                System.out.println("Vacancy");
                break;
            }
        }
    }
}