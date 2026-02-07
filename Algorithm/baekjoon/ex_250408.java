package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * description    : 15552번 : 빠른 A+B
 * packageName    : baekjoon
 * fileName        : ex_250408
 * author         : kimminsol
 * date           : 25. 4. 8.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 4. 8.        kimminsol       최초 생성
 */
public class ex_250408 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        for(int i=0; i<cnt; i++){
            String inputs = br.readLine();
            String[] values = inputs.split(" ");

            long sum = 0;
            for(String value : values){
                long temp = Long.parseLong(value);
                sum += temp;
            }
            bw.write(String.valueOf(sum) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
