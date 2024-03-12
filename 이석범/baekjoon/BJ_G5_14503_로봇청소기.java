package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * RxC�� �Է�
 * r c d // 0�� ��, 1�� ��, 2�� ��, 3�� ��
 * M���� �� // 0�� û��x, 1�� ��
 * 
 * �κ�û�ұ�
 * 1. ���� ĭ�� û�Ұ� x�̸� û��
 * 2. �ֺ� 4ĭ �� û�� �ȵ� ��ĭ�� ���� ���, �ٶ󺸴� ������ ��ġ�� ä
 * ��ĭ �����ϰ� 1������ ���ư�
 * �ٶ󺸴� ���� ĭ�� ���̶� ���� ���ϸ� �۵� �Ұ�
 * ��ĭ�� �ִ� ��� �ݽð� �������� 90�� ȸ��
 * �ٶ󺸸� ������ �������� ���� ĭ�� û��x�̸� ��ĭ ����
 * 1������ ���ư�
 * 
 * ����� û���ϴ� ĭ�� ����
 * 11852kb 88ms
 */
public class BJ_G5_14503_�κ�û�ұ� {
	static int R, C;
	
	static int[][] graph;
	
	//�� �� �� ��
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int cnt = 0;
	
	static void move(int r, int c, int dir) {
		//1�� ������
		if(graph[r][c] == 0) {
			graph[r][c] = 2;
//			System.out.println(r+" "+c);
			cnt++;
		}
		
		int nr, nc;
		
		//��ĭ Ȯ���ϱ�
		int zeroCnt = 0;
		for(int i=0; i<4;i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || graph[nr][nc] == 1) continue;
			
			if(graph[nr][nc] == 0) zeroCnt++;
		}
		
		//2�� �� ���
		if(zeroCnt == 0) {
			nr = r + dr[(dir+2) % 4];
			nc = c + dc[(dir+2) % 4];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || graph[nr][nc] == 1) return;
			move(nr, nc, dir);
		}
		//�ݽð�� ȸ��
		else {
			dir = dir - 1 >= 0 ? dir - 1 : 3;
			nr = r + dr[dir];
			nc = c + dc[dir];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C &&graph[nr][nc] == 0) {
				r = nr;
				c = nc;
			}
			move(r, c, dir);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		graph = new int[R][C];
		
		st = new StringTokenizer(br.readLine());
		int startR = Integer.parseInt(st.nextToken());
		int startC = Integer.parseInt(st.nextToken());
		int startDir = Integer.parseInt(st.nextToken());
		
		
		for(int r=0; r<R;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C;c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(startR, startC, startDir);
		System.out.println(cnt);
	}
}
