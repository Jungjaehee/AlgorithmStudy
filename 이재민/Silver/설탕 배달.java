import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2839 �������
 * 3kg�� 5kg�� 5kg�� ������ ���ƾ� ���� ���� ������ ������ �� ����
 * 3kg�� ��� ���ָ鼭 3kg ������ �ϳ��� ���ϸ鼭 5kg���� ��� ������
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int n5 = 0; // 5kg ����
		int n3 = 0; // 3kg ����

		while (true) {
			// �� �̻� ������ �߰� �� �� ������ �ݺ��� �ߴ�
			// t�� 0�̰ų� t�� 5�� ������ �������ٸ� ��Ȯ�� tų�α׷��� ���� �� ����
			// t�� 0���� ������ ��Ȯ�� tų�α׷� ���� �� �����Ƿ� -1�� ���
			if(t<=0) break;
			if(t%5 == 0) {
				n5 = t / 5;
				break;
			}
			n3++;
			t = t - 3;
		}
		
		if(t < 0) System.out.println(-1);
		else System.out.println(n5 + n3);

	}

}