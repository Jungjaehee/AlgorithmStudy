import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���� �ε��������� ������ ���ʿ��� ���� ū���� �����ʿ��� ���� ū ���� ����
 * �� �� ���� �� ��ŭ ����
 * ������ ���� �ε������� ���� ū �κ��� ���� �������� �ƴ� �ε��� �κ��̶�� ������ ���� �� ����
 * �ﰢ�� ���ؿ� ������ ���� �� �ֳ��� �����غ��� �ɵ�
 * 11800KB | 92ms 
 */

public class ���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int res = 0;
		int[] arr = new int[W];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < W - 1; i++) {
			
			int left = 0;
			int right = 0;
			
			for(int j=0; j<i; j++) {
				left = Math.max(left, arr[j]);
			}

			for(int j=i+1; j<W; j++) {
				right = Math.max(right, arr[j]);
			}
			
			res += (Math.min(left, right)  > arr[i]) ?
					Math.min(left, right) - arr[i] : 0;
		}
		
		System.out.println(res);
	}

}
