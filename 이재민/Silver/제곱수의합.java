import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * �ϳ��� �Ẹ�鼭 10������ �Ẹ�� ��Ģ�� ã�� �� ����
 * 1, 4, 9ó�� �������� ������ �����ϴ� ���� ������ 1�� ���� ����
 * � �� x�� ���� �� x�� �̷�� ���� �׺��� ���� ������ ������ ������ �̷������ ������
 * x���� 1^2, 2^2 ���� ���鼭 �ּҰ� ã��
 * 
 */
public class ���������� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		
		for(int i=1; i<=n; i++) {
			dp[i] = i;
			for(int j=1; j*j<=i; j++) {
				// ���� ���� ������ ������ ��� ������ + 1
				dp[i] = Math.min(dp[i], dp[i - j*j]+1); 
			}
		}
		System.out.println(dp[n]);
	}

}
