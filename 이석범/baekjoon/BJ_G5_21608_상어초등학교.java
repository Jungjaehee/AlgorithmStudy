package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//14660kb 120ms
public class BJ_G5_21608_����ʵ��б� {
	
	static boolean[][] graph;
	
	static int[][] map;
	
	static int N;
	
	static Deque<Integer> deque = new ArrayDeque<>();
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N*N+1][N*N+1];
		map = new int[N+1][N+1];
		
		for(int i=0; i<N*N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int idx = Integer.parseInt(st.nextToken());
			deque.addLast(idx);
			
			for(int j=0; j<4;j++) {
				int to = Integer.parseInt(st.nextToken());
				graph[idx][to] = true;
			}
		}
		boolean flag = false;
		while(!deque.isEmpty()) {
			int idx = deque.pollFirst();
			int resultR = 0;
			int resultC = 0;
			int resultCnt = 0;
			int resultBlank = 0;
			
			if(!flag) {
				map[2][2] = idx;
				flag = true;
				continue;
			}
			
			
			for(int r=1; r<=N;r++) {
				for(int c=1; c<=N;c++) {
					if(map[r][c]!= 0) continue;
					int tmpR = 1;
					int tmpC = 1;
					int tmpCnt = 0;
					int tmpBlankCnt = 0;
					
					for(int d=0; d<4;d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(nr <= 0 || nr > N || nc <= 0 || nc > N) continue;
						//�����̸� 
						if(map[nr][nc]==0) tmpBlankCnt++;
						
						//������ �ƴϰ� �����ϴ� �л��� ���cnt++
						else {
							if(graph[idx][map[nr][nc]]) {
								tmpCnt++;
							}
						}
					}
					
					//��ũ�� ������ ģ�� ã��
					//1�� �����ϴ� �л��� ������ ����
					if(resultCnt < tmpCnt) {
						resultR = r;
						resultC = c;
						resultCnt = tmpCnt;
						resultBlank = tmpBlankCnt;
					}
					//���� �Ÿ�
					else if(resultCnt == tmpCnt) {
						//2�� ���� ���� �� ����
						if(resultBlank < tmpBlankCnt) {
							resultR = r;
							resultC = c;
							resultCnt = tmpCnt;
							resultBlank = tmpBlankCnt;
						}
						//����ִ� ĭ�� ������ �׳� �������� ���
						//�� 0,0���� �ƹ��͵� �ȵǾ�������
						//������ ����
						else if(resultBlank==tmpBlankCnt) {
							if(resultR==0 && resultC==0) {
								resultR = r;
								resultC = c;
								resultCnt = tmpCnt;
								resultBlank = tmpBlankCnt;
							}
						}
					}
					
					
				}
			}
			map[resultR][resultC] = idx;

		}
		
		int result = 0;
		
		
		for(int r=1; r<=N;r++) {
			for(int c=1; c<=N;c++) {
				int from = map[r][c];
				int cnt = 0;
				for(int d=0; d<4;d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					
					if(nr <= 0 || nr > N || nc <= 0 || nc > N) continue;
					
					int to = map[nr][nc];
					
					if(graph[from][to]) cnt++;
				}
				if(cnt==0) continue;
				//0 1 10 100 100��
				result += (int)Math.pow(10, cnt-1);
			}
		}
		
		System.out.println(result);
		
//		for(int[] is:map) {
//			for(int i:is) {
//				System.out.print(i+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		
	}
}
