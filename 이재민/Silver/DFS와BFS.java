import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * dfs -> ���
 * bfs -> queue
 * 17600KB | 196ms
 */

public class DFS��BFS {

	static List<Integer>[] list;
	static boolean visited[];
	static int n, m;
	static Stack<Integer> s;
	static StringBuilder sb = new StringBuilder();

	// ���� ���(v)���� �� �� �ִ� ��带 ��� Ž��
	static void dfs(int v) {
		sb.append(v + " ");
		visited[v] = true;
		for (int i = 0; i < list[v].size(); i++) {
			int x = list[v].get(i);
			if (!visited[x]) {
				dfs(x);
			}
		}
	}

	// // ���� ���(v)���� �� �� �ִ� ��带 ť�� �ְ� ���� Ž��
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		while (!q.isEmpty()) {
			int x = q.poll();
			sb.append(x + " ");
			for (int i = 0; i < list[x].size(); i++) {
				int nx = list[x].get(i);
				if (!visited[nx]) {
					visited[nx] = true;
					q.add(nx);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
		}
		// ���ڰ� ���� ������ Ž���ϱ� ���� ����
		for (int i = 1; i <= n; i++) {
			list[i].sort(Comparator.naturalOrder());
		}

		visited = new boolean[n + 1];
		dfs(v);
		sb.append("\n");
		visited = new boolean[n + 1];
		bfs(v);
		System.out.println(sb.toString());
	}

}