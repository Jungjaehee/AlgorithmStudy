import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * �׷������� 0�� ���߰� ���� ��, 1�� ���߰� �ִ� ��
 * ���߰� �ִ� ���� ���� ����Ǿ� ������ 1������ �����������̷� ����� ���� ���� Ž���� �� ����
 * ���� ����� ������ ��� �ִ��� Ž���ϴ� bfs or dfs �׷��� Ž�� ����
 */

public class Main {
	
	// ��ǥ(x, y)�� ����ϱ� ���� Ŭ���� Pair
	public static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] map;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static boolean check(int x, int y, int m, int n) {
		if(x<0 || x>=m) return false;
		if(y<0 || y>=n) return false;
		if(map[x][y] == 0) return false;
		return true;
	}
	
	// bfs
	public static void bfs(int i, int j, int m, int n) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(i, j));
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.remove();
			
			for(int dir = 0; dir<4; dir++) {
				int nx = x + d[dir][0];
				int ny = y + d[dir][1];
				
				// ������ ����� �ʰ� ���߰� �ִ� ���̶��
				// ��Ž�� ���� �ʵ���(�ݺ����� �����ϰ� ���� �ʵ���) 0���� ����
				if(check(nx, ny, m, n)) {
					map[nx][ny] = 0;
					q.add(new Pair(nx, ny));
				}
			}
			
			
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc = 0; tc<t; tc++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int cnt = 0;
			map = new int[m][n];
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
			}
			
			// ���������� �׷����� ���ٰ� ���߰� �ִ� ���� �߰��ϰ�
			// ���߰� �ִ� ���� �����������̰� �ֺ� ���߿��� �����ϱ� ������ bfs 
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == 1) {
						bfs(i, j, m, n);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
		
		
	}

}