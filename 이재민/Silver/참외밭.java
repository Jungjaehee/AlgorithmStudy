import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		
		int[] len = new int[6];
		List<Integer> small = new ArrayList<>();
		int sum = 0;
		int max_x = 0, max_y = 0;
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
			
			// ���� ���ο��� ���� ū ũ�� ���ϱ�
			if(d <= 2) {
				max_x = Math.max(max_x, len[i]);
			}
			else {
				max_y = Math.max(max_y, len[i]);
			}
			
		}
		
		for(int i=0; i<6; i++) {
			// �׸� ������ ���� �ε����� len[i-1] + len[i+1]�� ������ ������ ����
			// ���� �Ǵ� ������ �ִ밪�̶� ��ġ�Ѵٸ� ���� �簢���� ���� ���� ������ �ϳ���
			
			// 50 160 30 60 20 100
			// 60�� ����(30) ������(20) ���ϸ� 50�̰� ������ �ִ밪�̶� ����
			// 20�� ����(60) ������(100) ���ϸ� 160�̰� ������ �ִ밪�̶� ����
			// 20�� 60�� ���� �簢���� ���� ���� ���̰� �Ǵ� ��
			int l = 0;
			
			
			// �ε��� ���� �ʰ� ����
			l+= len[i==0 ? 5 : i-1] + len[(i+1)%6];

			if(l == max_x || l == max_y) {
				small.add(len[i]);
			}
			
		}
		
		sum += max_x * max_y;
		
		// ArrayList�� ��� ���� ���� ��
		sum -= small.stream().reduce(1, (x, y) -> x*y);
		System.out.println(sum*n);

		
	}

}
