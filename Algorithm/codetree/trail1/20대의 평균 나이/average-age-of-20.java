/* 
    몇 명의 사람들의 나이가 차례대로 주어질 때, 
    처음으로 20대가 아닌 다른 나이대의 사람이 나오기 전까지 
    입력된 나이들의 평균을 구하는 프로그램
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0, cnt = 0;

        while (true) {
            int age = sc.nextInt();

            if(age/10 != 2){    // 20대가 아닌 경우
                System.out.printf("%.2f", (double)sum/cnt);
                break;
            } else {            // 20대인 경우
                sum += age;
                cnt++;
            }
        }

        sc.close();
    }
}