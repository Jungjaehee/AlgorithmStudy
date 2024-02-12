import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2630_�����̸���� {
	/**
	 * 1. ���ǿ� ���� �ʴ� ���, ������ �ݾ� �ٿ��� Ž���ϴ� ��� �Լ�
	 * 2. ĭ �ȿ� ��� ���� ���̰ų�, ĭ�� 1���� ����� ������ �˻��ϴ� �Լ�
	 * 
	 * �ð�: 112ms, �޸�: 13,664KB
	 */
	static String[][] paper;  // ������ ���� �迭
	static int[] res = new int[2];  // 0: �Ͼ��, 1: �Ķ���
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		paper = new String[N][];
		
		for (int i = 0; i < N; i++) {
			paper[i] = br.readLine().split(" ");
		}
		
		splitSearch(0, 0, N);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
	/**
	 * 
	 * @param r : ���� ���� ��ġ
	 * @param c : ���� ���� ��ġ
	 * @param n : ������ ũ��
	 */
	private static void splitSearch(int r, int c, int n) {
		if(n == 1 || search(r, c, n)) {   // ��� ���� ���̰ų� ĭ�� 1���� ���, ����
			res[Integer.parseInt(paper[r][c])]++;
			return;
		}
		int newN = n/2;
		// ���� 4����ؼ� �ݺ� �۾� ����
		splitSearch(r, c, newN);
		splitSearch(r+newN, c, newN);
		splitSearch(r, c+newN, newN);
		splitSearch(r+newN, c+newN, newN);
	}
	
	/**
	 * �ش� ���� �ȿ� ��� ���� �������� �˻��ϴ� �Լ�
	 * @param r : ���� ���� ��ġ
	 * @param c : ���� ���� ��ġ
	 * @param n : ������ ũ��
	 * @return true: �ش� ������ ���� ��� �����ϴ�
	 */
	private static boolean search(int r, int c, int n) {
		String preV = paper[r][c];
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if(!preV.equals(paper[i][j])) return false;
			}
		}
		return true;
	}

}
