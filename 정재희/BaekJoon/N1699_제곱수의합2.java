import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  ���� Ǯ�̸� �����Ͽ� �����Ͽ����ϴ�.
 *  
 * i\n  0   1   2   3   4   5   6   7   8   9   10   11
 * 1^2  0   1   2   3   4   5   6   7   8   9   10   11
 * 2^2  // //  //  //   1   2   3   4   2   3   4    5   -> i^2���� �� �Է�, min((i-1, n), (i-1, n-4)+1)
 * 3^2  // //  //  //  //  //  //  //  //   1   2    3  
 * 
 *  �ð�: 144ms  |  �޸�: 12,644KB
 */
public class N1699_����������2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = (int)Math.sqrt(N);
		
		int[] dp = new int[N+1];
		
		for (int i = 0; i < N+1; i++) {  // 1�� �������� ǥ���Ǵ� �������� ����, �ʱⰪ���� ����
			dp[i] = i;
		}
		
		for (int i = 2; i < M+1; i++) {
			int r = (int) Math.pow(i, 2);  // i�� �������ĺ��� dp�迭 ������Ʈ ����
			for (int j = r; j < N+1; j++) {
				dp[j] = Math.min(dp[j],  dp[j-r]+1);
			}
		}
		System.out.println(dp[N]);		
	}
	
}
