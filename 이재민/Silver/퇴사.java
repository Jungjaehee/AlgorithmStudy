import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		
		//�յڷ� ������ �ϳ��� �� �Ҵ�
		int[] t = new int[n+2];
		int[] p = new int[n+2];
		int[] dp = new int[n+2];
		
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		// bottom-up
		for(int i=1; i<=n; i++) {
			if(i + t[i] < n+2) { // �ð� �Ѿ�� �ʴ� ������
				dp[i] = Math.max(dp[i], dp[i-1]); // ���� ���� �ʴ°� �̵��� �� ����
				
				// 1������ 3�� ���ϸ� 1, 2, 3�� ���ϴ°Ű� �ݾ��� 4�Ͽ� �޴´ٰ� �����ϰ� dp[4]�� �����ϴ� ��
				// �ݾ� �޴³� �̹� ����Ǿ� �ִ� ���� (�����ϴ³��� ����� �� + ���ϸ� �޴°�)�� ��
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
				max = Math.max(max, dp[i + t[i]]); // �׻� ������ ������ ���ؾ� �ϴ� ������ ���� ������ �ִ밪 ����
			}
		}
		
		System.out.println(max);
	}
}
