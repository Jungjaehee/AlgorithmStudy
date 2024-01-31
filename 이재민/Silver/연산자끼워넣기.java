import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * n�� ������ ũ�� �ʾ� ��͸� �̿��� ����Ž��
 * ���� 3���� input�� 5! / 2!�� 60������ ����� ���� ����
 * ������ ���� ���� �ٸ��ٰ� �ǴܵǴ� �����̰� �ߺ��� ����ϱ� ������ �ߺ� �����̶�� �����ϸ� ����
 */

public class �����ڳ����ֱ� {

	static int[] arr;
	static int[] oper;
	static int maxRes = Integer.MIN_VALUE; // 0���� �ʱ�ȭ�ϸ� �ȵ�
	static int minRes = Integer.MAX_VALUE; // 0���� �ʱ�ȭ�ϸ� �ȵ�
	static int n;
	static int c;
	
	public static void operation(int idx, int res, int cnt) {
		
		// �����ڸ� �� ���� �־����� max min ������ ���� �ְ� ����
		if(cnt == n-1) {
			c++;
			maxRes = Math.max(maxRes, res);
			minRes = Math.min(minRes, res);
			return ;
		}
		
		
		// ��͸� ���� ���� ����
		// �ߺ������� ������ ����
		for(int i=0; i<4; i++) {
			if(oper[i] > 0) {
				oper[i]--;
				if(i==0) {
					operation(idx+1, res + arr[idx], cnt+1);
				}
				else if(i==1) {
					operation(idx+1, res - arr[idx], cnt+1); 
				}
				else if(i==2) {
					operation(idx+1, res * arr[idx], cnt+1); 
				}
				else {
					operation(idx+1, res / arr[idx], cnt+1); 
				}
				oper[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		oper = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		// res�� arr[0]�� �Ѱ� �־����� �ε����� 1���� ����
		operation(1, arr[0], 0);
		
		System.out.println(maxRes);
		System.out.println(minRes);
	}


}
