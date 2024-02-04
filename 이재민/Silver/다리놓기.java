
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N�� M�� ������ ũ�� ������ �����÷ο� �Ǵ� �ð��ʰ��� �� �� ����
 * DP �̿�
 * 15396KB | 156ms
 */
public class �ٸ����� {

	// nCr ������ ���� ���ϱ� func(n-1, r-1) + func(n-1, r)
	// �ѹ� ���� nCr�� ���� �� �ٽ� ������ �ʱ����� dp�迭�� ����
	static int dpf(int n, int m, int[][] dp) {
		if(n==m || m==0) return 1;
		
		if(dp[n][m] != 0) return dp[n][m];
		
		return dp[n][m] = dpf(n-1, m-1, dp) + dpf(n-1, m, dp);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int [][]dp = new int[n+1][m+1];
			
			sb.append(dpf(n, m, dp) + "\n");
		
		}
		System.out.println(sb);
		
	}

}
