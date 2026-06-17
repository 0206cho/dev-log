// 점수를 입력받아 통과인지, 통과를 못 했다면 몇 점이 더 필요한지 출력하는 프로그램
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n>=80){
            System.out.println("pass");
        } else {
            System.out.println(80-n + " more score");
        }

        sc.close();
    }
}