/*
  N만큼의 돈으로 살 수 있는 물건 중 가장 비싼 물건을 출력하는 프로그램

  물건   가격
  book  3000
  mask  1000
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();

      if(n >=3000) {
        System.out.println("book");
      } else if(n >=1000) {
        System.out.println("mask");
      } else {
        System.out.println("no");
      }
      sc.close();
    }
}