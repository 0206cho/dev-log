package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * description    : 10988번 :  팰린드롬인지 확인하기
 * packageName    : baekjoon
 * fileName        : ex_250413
 * author         : kimminsol
 * date           : 25. 4. 13.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 4. 13.        kimminsol       최초 생성
 */
public class ex_250413 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 확인할 문자열 입력
        String inputs = br.readLine();

        // 2. 팰린드롬인지 확인
        String value = "1";

        int idx = inputs.length();
        for(int i = 0; i <= idx/2; i++) {
            if(inputs.charAt(i) != inputs.charAt(idx-1-i)) {
                value = "0";
                break;
            }
        }

        bw.write(value);

        bw.flush();
        bw.close();
    }
}
