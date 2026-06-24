package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * description    : 2798번 : 블랙잭
 * packageName    : baekjoon
 * fileName       : ex_250417
 * author         : kimminsol
 * date           : 25. 4. 17.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 4. 17.        kimminsol       최초 생성
 */

public class ex_250417 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp = br.readLine();
		// 1. 입력 - 카드 개수
		int n = Integer.parseInt(temp.split(" ")[0]);
		
		// 1. 입력 - 숫자
		int m = Integer.parseInt(temp.split(" ")[1]);

		// 1. 입력 - 카드에 쓰여진 수
		int inputs[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		// 2. 계산
		int value = fn_search(inputs, n, m);
		bw.write(String.valueOf(value));
		
		bw.flush();
		bw.close();
	}
	
	public static int fn_search(int[] inputs, int n, int m) {
		int value = 0;
		
		// 3중 반복문 - 선택하는 카드가 3장이기 때문
		for(int i = 0; i <n-2; i++) {
			
			// 처음 뽑은 카드가 m보다 크면 스킵
			if(inputs[i] > m) { 
				continue;
			}
			
			// 두 번째 카드는 처음에 뽑은 카드의 다음 카드부터 뽑을 수 있음
			for(int j=i+1; j <n-1; j++) {
				
				if(inputs[i] + inputs[j] > m) {
					continue; // 처음과 두번째 뽑은 카드의 합이 m보다 크면 스킵
				}
				
				// 세 번째 카드는 그 전에 뽑은 다음 카드부터 뽑을 수 있음
				for(int k=j+1; k <n; k++) {
					int sum = inputs[i] + inputs[j] + inputs[k];
					if(sum > m) {
						continue; // 세 개의 카드 합이 m보다 크면 스킵
					} else if(sum == m) {
						// 세 개 카드의 합이 m과 같다면 최고의 카드 합이므로 바로 리턴
						value = sum;
						break;
					} else if(sum < m && sum > value) {
						value = sum;
					}
				}
			}
		}
		
		return value;
	}
}

