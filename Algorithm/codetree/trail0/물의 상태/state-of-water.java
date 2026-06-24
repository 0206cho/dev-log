/*
    물의 온도를 정수로 입력받아 0℃ 미만일경우엔 ice, 
    100℃ 이상일때는vapor, 그 외의 경우는 water 라고 출력하는 프로그램
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n < 0) {
            System.out.println("ice");
        } else if(n >= 100) {
            System.out.println("vapor");
        } else {
            System.out.println("water");
        }

        sc.close();
    }
}