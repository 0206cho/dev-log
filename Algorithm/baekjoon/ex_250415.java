package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * description    : 2750번 : 수 정렬하기
 * packageName    : baekjoon
 * fileName        : ex_250415
 * author         : kimminsol
 * date           : 25. 4. 15.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 4. 15.        kimminsol       최초 생성
 */
public class ex_250415 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력 - 입력받을 정수의 개수
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];

        for(int i=0; i < n; i ++) {
            // 1. 입력 - 정렬할 n개의 정수
            values[i] = Integer.parseInt(br.readLine());
        }

        // 2. 정렬하기
        Arrays.sort(values);

        // 3. 결과 출력
        for(int value : values) {
            bw.write(value + "\n");
        }

        bw.flush();
        bw.close();
    }
}
