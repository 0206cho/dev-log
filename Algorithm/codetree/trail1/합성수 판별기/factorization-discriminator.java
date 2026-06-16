/*
    정수 N이 2 이상 (N−1) 이하의 어떤 정수로 나누어 떨어진다면, N은 합성수

    ex) 35는 5로 나누어 떨어지므로 합성수. 
        13은 2 이상 12 이하의 어떤 정수로도 나누어 떨어지지 않으므로 합성수가 아님

    정수 N이 주어질 때, N이 합성수인지 아닌지 판별하는 프로그램
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean check = false;

        for(int i=2; i<=(n-1); i++){
            if(n%i==0){
                check = true;
            }
        }

        System.out.println(check?"C":"N");
        
        sc.close();
    }
}