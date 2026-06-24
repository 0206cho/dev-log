package baekjoon;

import java.io.*;

/**
 * description    : 8393번 : 합
 * packageName    : baekjoon
 * fileName        : ex_250410
 * author         : kimminsol
 * date           : 25. 4. 10.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 4. 10.        kimminsol       최초 생성
 */
public class ex_250410 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i=0; i <n; i++) {
            sum += i+1;
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }
}
