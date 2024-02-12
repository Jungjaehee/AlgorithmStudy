import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2578_���� {
	/**
	 * 1. ö���� �� �� ����
	 *   1) 1~25 ���� -> ���� �ε����� ���, 2���� �迭�� ��ġ �� ����
	 *   
	 * 2. ��ȸ�ڰ� �θ��� �� üũ (�ݺ��� 5*5)
	 *   1) ������ �ε��� ���� -> ��ġ �� �ޱ�
	 *   2) �ش� ��� ���� ���� ���� ����, �밢�� ��ġ��� �밢�� ���� ���� ����
	 *   3) ������ ������ 5�� ��, ��ü ���� ī��Ʈ ����
	 *   4) ī��Ʈ�� 3�̻��� ��, ��� �� ����
	 *     - i=0~4, j=1~5 �� ��, ��ȸ�ڰ� �θ� ��: i*N+j
	 * 
	 * �ð�: 72ms | �޸�: 11,560KB
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = 5;
		int[][] locate = new int[N*N+1][2];  // ö���� �� �� ��ġ ����
		int[] checkR = new int[N];  // �� ���� ���� üũ
		int[] checkC = new int[N];   // �� ���� ���� üũ
		int[] checkDiag = new int[2];  // �밢�� ���� ���� üũ
		int cnt = 0;  // ��ü ���� ī��Ʈ ����
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				locate[val][0] = i;   // ö���� �� ���� �ε����� ���, ��ġ �� ����
				locate[val][1] = j;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 5; j++) {
				int ans = Integer.parseInt(st.nextToken());  //��ȸ�ڰ� �θ� ��
				int r = locate[ans][0];   // �ش� ���� ��ġ ��������
				int c = locate[ans][1];
				
				// �ش� ���� �� ���� ī��Ʈ ������ ���ÿ� 5�� ��, ���� ī��Ʈ ����
				if(++checkR[r] == N) cnt++;
				
				// �ش� ���� �� ���� ī��Ʈ ������ ���ÿ� 5�� ��, ���� ī��Ʈ ����
				if(++checkC[c] == N) cnt++;
				
				// �밢�� ���� ��, ���� �ش��ϴ� �밢�� ���� ī��Ʈ ������ ���ÿ� 5�� ��, ���� ī��Ʈ ����
				if(r==c && ++checkDiag[0] == N) cnt++;
				if((r+c) == (N-1) && ++checkDiag[1] == N) cnt++;
				
				// ���� 3�� �̻��� ��, ��� �� ����
 				if(cnt >= 3) {
					System.out.println(i*N+j);
					return;
				}
			}
		}
		
	}
}
