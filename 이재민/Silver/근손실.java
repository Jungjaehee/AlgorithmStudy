import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * ������ ���ϴ� ����
 */

public class Main {

	static int[] arr;
	static int[] v;
	static boolean[] visited;
	static int res = 0;

	// ���� dfs
	static void dfs(int n, int k, int cnt, int sum) {
		
		// n���� n���� �̴� ����
		if (cnt == n) {
			res++;
			return;
		}

		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				// ���� ���� �������� �߷��� 500�� ���� ������ ��͸� �������� ����
				if (sum + arr[i] - k >= 500) {
					v[cnt] = arr[i];
					visited[i] = true;
					dfs(n, k, cnt + 1, sum + arr[i] - k);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		v = new int[n];
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(n, k, 0, 500);

		System.out.println(res);
	}
}
