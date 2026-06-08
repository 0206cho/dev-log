/*
    시험점수에 따라 등급을 정함
    90점 이상이면 A,
    80점 이상이면 B,
    70점 이상이면 C,
    60점 이상이면 D,
    60점 미만이면 F 
    주어지는 점수 N부터 100점까지 1점씩 증가하며 각 점수가 어떤 등급에 해당하는지 출력하는 프로그램
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 출력
        for(int i =n; i<=100; i++){
            if(i>=90){
                System.out.print("A ");
            } else if(i>=80){
                System.out.print("B ");
            } else if(i>=70){
                System.out.print("C ");
            } else if(i>=60){
                System.out.print("D ");
            } else {
                System.out.print("F ");
            }
        }
    }
}