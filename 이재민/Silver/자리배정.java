import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] d = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	// Pair�� ��ü�� �޾Ƽ� ��ǥ�� �ѹ��� ǥ��
	public static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// ������ ����ų� �̹� �湮�� ������ üũ
	public static boolean check(int x, int y, int r, int c, int[][] map) {
		if (x < 0 || x >= r)
			return false;
		if (y < 0 || y >= c)
			return false;
		if (map[x][y] != 0)
			return false;
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());

		// ������ �¼��� ũ�⺸�� ����ȣ�� ũ�� ������ �� �� ����
		if (r * c < k) {
			System.out.println(0);
			return;
		}
		
		int[][] map = new int[r][c]; // ���� ���� �ݴ�� ����
		int resX = 0, resY = 0; // ����� ����

		int i = 0; // �������� �ð�������� ���� ���� idx

		map[0][0] = 1; // ���� ������ 1�� �����������
		Queue<Pair> q = new LinkedList<>(); // bfs queue
		q.add(new Pair(0, 0));

		// queue start
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.remove();
			
			// ���� ����
			if (map[x][y] == k) {
				resX = y;
				resY = x;
				break;
			}

			int nx = x + d[i % 4][0];
			int ny = y + d[i % 4][1];
			
			// d�迭�� �� �� �� �� ������ �Ǿ� ����
			// üũ �ϰ� �������� ����� i�� ũ�⸦ �÷��ְ� %�� �� �� �� �� ������ ��� �̵� 
			if (!check(nx, ny, r, c, map)) {
				i++;
				nx = x + d[i % 4][0];
				ny = y + d[i % 4][1];
			}

			q.add(new Pair(nx, ny));
			map[nx][ny] = map[x][y] + 1;

		}

		System.out.println((resX + 1) + " " + (resY + 1));
	}
}
