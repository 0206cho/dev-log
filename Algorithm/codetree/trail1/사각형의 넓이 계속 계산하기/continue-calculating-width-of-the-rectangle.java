// 사각형의 가로세로의 길이와 문자가 주어짐. 문자 C가 주어지는 줄까지 사각형의 넓이를 구하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            char c = sc.next().charAt(0);

            System.out.println(a * b);

            if(c == 'C') {
                break;
            }
        }
        
        sc.close();
    }
}