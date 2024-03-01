package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *NxMũ�� T�ð� ���� �����ؾ���
 *0, 0���� ���� N,M�� ��ġ�� �ִ� ���ָ� ���ؾ���
 *��Ȯ�� T�ð��� �����ص� ����
 *0,0�� �׶��� ������ ���� ���� ��?
 *100x100�̸� ������� ��
 *13372kb 136ms
 */
public class BJ_G5_17836_���ִ������ض� {
	static int R, C, T;
	
	static int[][] graph;
	
	static class Node {
		int r;
		int c;
		boolean flag;
		
		Node(int r, int c, boolean flag) {
			this.r = r;
			this.c = c;
			this.flag = flag;
		}
	}
	
	//0�� �Ϲ� 1�� �׶�
	static boolean[][][] visited;
	
	static int[] gram = new int[2];
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int BFS() {
		Queue<Node> queue = new ArrayDeque<>();
		
		if(gram[0] == 0 && gram[1]==0) {
			queue.offer(new Node(0, 0, true));
			visited[1][0][0] = true;
		}
		else {
			queue.offer(new Node(0, 0, false));
			visited[0][0][0] = true;
		}
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(--size>=0) {
				Node current = queue.poll();
				
				if(current.r == R-1 && current.c == C-1) return cnt;
				
				for(int d=0; d<4;d++) {
					int nr = current.r + dr[d];
					int nc = current.c + dc[d];
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					
					//�׶� �ΰ��
					if(current.flag) {
						if(visited[1][nr][nc]) continue;
						visited[1][nr][nc] = true;
						queue.offer(new Node(nr, nc, true));
						
					}
					
					//�ƴ� ���
					else {
						if(visited[0][nr][nc] || graph[nr][nc] == 1) continue;
						
						if(graph[nr][nc] == 2) {
							visited[1][nr][nc] = true;
							queue.offer(new Node(nr, nc, true));
						}
						else {
							visited[0][nr][nc] = true;
							queue.offer(new Node(nr, nc, false));
							
						}
						
					}
					
				}
			}
			cnt++;
			if(cnt > T) return 0;
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		graph = new int[R][C];
		visited = new boolean[2][R][C];
		
		for(int r=0; r<R;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C;c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		//�׶� ã��
		for(int r=0; r<R;r++) {
			for(int c=0; c<C;c++) {
				if(graph[r][c]==2) {
					gram[0] = r;
					gram[1] = c;
					break;
				}
			}
		}
		int result = BFS();
		System.out.println(result == 0 ? "Fail":result);
	}
}
