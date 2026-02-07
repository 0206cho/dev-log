package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * description    : 2738번 :  행렬 덧셈
 * packageName    : baekjoon
 * fileName        : ex_250412
 * author         : kimminsol
 * date           : 25. 4. 12.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 4. 12.        kimminsol       최초 생성
 */
public class ex_250412 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 행렬의 크기 N, M <= 100
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[][] values = new int[n][m];

        for(int k=0; k<=1; k++) {
            for(int i=0; i<=n-1; i++) {
                String temp = br.readLine();
                for(int j=0; j<=m-1; j++) {
                    values[i][j] += Integer.parseInt(temp.split(" ")[j]);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                bw.write(values[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
