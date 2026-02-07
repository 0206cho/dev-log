package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * description    : 1152번 : 단어의 개수
 * packageName    : baekjoon
 * fileName        : ex_250414
 * author         : kimminsol
 * date           : 25. 4. 14.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 4. 14.        kimminsol       최초 생성
 */
public class ex_250414 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 문자열 입력
        String inputs = br.readLine();

        // 2. 단어 개수 세기
        // 2-1. 공백 아닌 단어
        if (inputs != null && !inputs.trim().isEmpty()) {
            // 2-2. 중복 공백 -> 공백 1개
            String[] input = inputs.trim().split("\\s+");

            // 3. 결과 출력
            bw.write(String.valueOf(input.length));
        } else {
            // 3. 결과 출력 - 공백으로만 이루어진 단어일 경우
            bw.write("0");
        }

        bw.flush();
        bw.close();
    }
}
