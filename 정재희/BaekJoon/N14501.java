package ������.BaekJoon;

import java.util.Scanner;

public class N14501 {
	// ��Ʃ�� ������ �����Ͽ� �����Ͽ����ϴ�.
	// �� ���� ����� ���� ������� ���� ��� ���
	/**  �ڿ��� ���� �Ǵ�
	 *   1. ����� �������� �Ǵ� (��� ���� Ȯ��)
	 *   2. ����� �Ѵ�? --> ��� ���� ��¥�� ���� ���� ���� ���� (dp[i+T[i]] + p[i])
	 *   3. ����� ���Ѵ�? --> �� ���� ���� ��� �״�� ������ (dp[i+1]) (���� ����� ��������, �������� ����� ���� ����)
	 *   4. 2�� 3�߿� ū ���� �����Ͽ� ����
	 *   5. �ݺ�
	 *   Day  1  2  3  4  5  6  7 
	 *   Ti   3  5  1  1  2  4  2
	 *   Pi   10 20 10 20 15 40 200
	 * 		  ________________���Ұ�
	 * 	��� O |45|20|45|35|15| 0| 0|
	 * 	��� X |45|45|35|15|_0|_0|_0|
	 */	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] T = new int[N];
		int[] P = new int[N];
		int[] dp = new int[N+1];
		
		/* input */
		for(int i=0;i<N;i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		for(int i=N-1;i>-1;i--) {  // �ڿ������� ����
			int nxt_days = i + T[i];  // ����� ���� ���� ��
			if(nxt_days > N) dp[i] = dp[i+1];  // ��� ���� ��踦 �Ѿ�� ���, i+1�� ���� ������ ����
			else {   // ����� �Ⱓ �ȿ� ������ ���, ����� �� ���� ���� ���� ��쿡 ���� �ִ� ���
				dp[i] = Math.max(P[i] + dp[nxt_days], dp[i+1]);
			}
		}
		System.out.println(dp[0]);	
	}

}

