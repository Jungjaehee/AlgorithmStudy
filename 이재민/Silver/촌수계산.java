import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * ���� ������ ���� ��带 ���� ��� + 1�� �ؼ� �������� �����ָ� ��
 * BFS ���
 * �Է��� List�� �迭 ��, 2���� �迭 ���
 * 11652KB | 76ms
 */

public class �̼���� {

	static int n, start, end , m; // ��� ��, ���ؾ� �ϴ� ������� �̼�, ������ ����
	static List<Integer> list[];
	static int visited[]; // �湮 üũ �� �̼� ���ϱ�

	
	public static int bfs(int v) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(v);
		visited[v] = 1; // ���� ����� ���� 0�̸� �湮üũ �ϱⰡ �����
		int res = -1;
		while(!q.isEmpty()) {
			int x = q.peek();
			q.poll();
			
			// 1�� ������ �߱� ������ -1�ؼ� ���� �Ѱ���
			if(x == end) {
				res = visited[x]-1;
				break;
			}
			
			for(int i=0; i<list[x].size(); i++) {
				int nx = list[x].get(i);
				if(visited[nx] == 0) {
					visited[nx] = visited[x] + 1; // nx�� x�� + 1�� ������ ��
					q.add(nx);
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			list[x].add(y);
			list[y].add(x);
		}
		
		visited = new int[n+1];
		System.out.println(bfs(start));
	}

}