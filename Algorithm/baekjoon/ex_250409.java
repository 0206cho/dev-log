package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * description    : 25304번 : 영수증
 * packageName    : baekjoon
 * fileName        : ex_250409
 * author         : kimminsol
 * date           : 25. 4. 9.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 4. 9.        kimminsol       최초 생성
 */
public class ex_250409 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // X : 영수증에 적힌 총 금액
        long x = Long.parseLong(br.readLine());

        // N : 영수증에 적힌 구매한 물건의 종류의 개수
        int n = Integer.parseInt(br.readLine());

        // N개의 줄에는 각 물건의 가격 a와 개수 b가 공백을 사이에 두고 주어

        int sum = 0;
        for(int i =0; i<n; i++) {
            String inputs = br.readLine();
            String[] value = inputs.split(" ");


            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);

            sum += a*b;

        }

        if(x == sum) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }

        bw.flush();
        bw.close();

    }
}
