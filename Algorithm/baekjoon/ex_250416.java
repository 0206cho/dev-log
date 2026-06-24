package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * description    : 2587번 : 대표값2
 * packageName    : baekjoon
 * fileName        : ex_250416
 * author         : kimminsol
 * date           : 25. 4. 16.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 4. 16.        kimminsol       최초 생성
 */
public class ex_250416 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] inputs = new int[5];
        int sum = 0;
        for(int i =0; i<5; i++){
            inputs[i] = Integer.parseInt(br.readLine());
            sum += inputs[i];
        }

        bw.write(sum / 5 + "\n");

        Arrays.sort(inputs);
        bw.write(String.valueOf(inputs[2]));

        bw.flush();
        bw.close();
    }
}
