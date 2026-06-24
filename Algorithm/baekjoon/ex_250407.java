package baekjoon;

import java.util.Scanner;

/**
 * description    : 11382번 : 꼬마 정민
 * packageName    : baekjoon
 * fileName        : ex_250407
 * author         : kimminsol
 * date           : 25. 4. 7.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 4. 7.        kimminsol       최초 생성
 */
public class ex_250407 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String inputs = sc.nextLine();
        String[] values = inputs.split(" ");

        long sum = 0;
        for (String value : values) {
            long temp = Long.parseLong(value);
            sum += temp;
        }

        System.out.println(sum);
    }
}
