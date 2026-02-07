package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * description    : 10818번 :  최소, 최대
 * packageName    : baekjoon
 * fileName        : ex_250411
 * author         : kimminsol
 * date           : 25. 4. 11.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 4. 11.        kimminsol       최초 생성
 */
public class ex_250411 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long mmax = -1000000;
        long mmin = 1000000;

        String[] inputs = br.readLine().split(" ");
        for(int i =0; i<n; i++) {
            long temp = Long.parseLong(inputs[i]);
            mmax = Math.max(temp, mmax);
            mmin = Math.min(temp, mmin);
        }

        bw.write(String.valueOf(mmin +" " + mmax));
        bw.flush();
        bw.close();
    }
}
