package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *�����̽� �������� ��
 *
 *ó������ �ִ°� ���� �ؾ���
 *168616kb 520ms
 */
public class BJ_G4_15961_ȸ���ʹ� {
	
	static int maxResult;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int maxNum = Integer.parseInt(st.nextToken());
		int setNum = Integer.parseInt(st.nextToken());
		int bonus = Integer.parseInt(st.nextToken());

		//������ 0��° ���� n��°���� �̰� maxNum���� ���� 
		int[] list = new int[N];
		
		int[] check = new int[maxNum+1];
		
		for(int i=0; i<N;i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		//�ʱ⿡ ���� 
		//���ʽ��� ó������ �ֱ�
		int cnt = 1;
		check[bonus]++;
		
		for(int i=0; i<setNum;i++) {
			if(check[list[i]]==0) cnt++;
			check[list[i]]++;
		}
		
		//���߿� ������ ��ø��
//		if(check[bonus]==0) cnt++;
		maxResult = cnt;
		
		for(int i=0;i<N-1;i++) {
			if(check[list[i]]==1) cnt--;

			check[list[i]]--;
			
			int next = list[(i+setNum)%N];
			
			if(check[next]==0) cnt++;
			check[next]++;
//			if(check[bonus]==0) cnt++;
			maxResult = Math.max(maxResult, cnt);
		}
		
		System.out.println(maxResult);
		
	}
}
