package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *NxMxB
 *���� ���̴� 256
 *
 *��� ���� �� �κ��丮 2��
 *��� �ϳ� ������ ����� 1��
 *
 *�ּҽð��� ���� ����
 *34460kb 692ms
 */
public class BJ_S2_18111_����ũ����Ʈ {
	
	
	static final int MAX = 256;

	static int R, C, inventory;

	static int[][] graph;

	static int[][] time = new int[MAX+1][2];

	static int minTime = Integer.MAX_VALUE;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		inventory = Integer.parseInt(st.nextToken());

		graph = new int[R][C];
		
		//�׷������� �ִ밪���� �߰� �ϴ°��� �ð� �ּҰ� ��
		int maxNum = Integer.MIN_VALUE;

		for(int r=0; r<R;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C;c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
				maxNum = Math.max(maxNum, graph[r][c]);
			}
		}

		//��� ���� i���� �Ǵ� ���
		A: for(int i=0; i<=maxNum;i++) {
			for(int r=0; r<R;r++) {
				for(int c=0; c<C;c++) {
					//��Ʈ��ŷ ������ ���̱� ���� ������ �ּҽð����� ũ�� �ٷ� ���� �ε���
					if(time[i][0] > minTime) continue A;

					//������ �ƹ��͵� ����
					if(graph[r][c] == i) continue;
					else if(graph[r][c] > i) {
						time[i][0] += 2*(graph[r][c]-i);
						time[i][1] += (graph[r][c]-i);
					}

					//i���� ������ 1�ʸ� �߰� �κ����� 1����
					//0�� �ð��� ��Ÿ�� 1�� ��� ��
					else {
						time[i][0] += (i-graph[r][c]);
						time[i][1] -= (i-graph[r][c]);
					}

				}
			}

			//�ð��� ���ų� ���� �κ��丮�� ��ϼ��� ������ �ƴϸ� ����
			if(time[i][0] <= minTime & (inventory + time[i][1]) >= 0 ) {
				minTime = time[i][0];
				result = i;
			}
		}



		System.out.println(minTime+" "+result);


	}
}
