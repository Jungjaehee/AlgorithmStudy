package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author SEOK BEOM LEE
 *38320kb 1104ms
 *
 * ���ڿ��� ���ϸ鼭 �� ��� �ð��ʰ� ��
 *������ �̿��ؾ���
 */
public class BJ_G4_9935_���ڿ����� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//���� �ؽ�Ʈ
		String text = st.nextToken();
		st = new StringTokenizer(br.readLine());
		
		//üũ�ؾ��� �ؽ�Ʈ
		String check = st.nextToken();
		
		//������ ����
		int textLen = text.length();
		int checkLen = check.length();
		
		//�������� �ϴ� ������ �߰����� get���� üũ�ؾ��ϹǷ� deque��� ���
		Stack<Character> stack = new Stack<>();

		for(int i=0; i<textLen;i++) {
			//��Ī�̵� �� ī��Ʈ
			int cnt = 0;
			stack.push(text.charAt(i));
			
			//����� üũ���̺��� ���ų� ũ�� ������ ��
			if(stack.size()>=checkLen) {
				
				//���� ���ÿ��� �������� ���ڿ� ���̸�ŭ ���鼭 ������ cnt++
				for(int j=0; j<checkLen;j++) {
					if(stack.get(stack.size()-checkLen + j) == check.charAt(j)) {
						cnt++;
					}
					//���� ������ �� �͵� �� ������
					if(cnt==checkLen) {
						for(int k=0; k<checkLen;k++) {
							stack.pop();
						}
					}
				}
			}
		}
		
		//��������� frula��ȯ
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}
		//�ƴϸ� ���ÿ��� ���
		else {
			StringBuilder sb = new StringBuilder();
			for(char ch: stack) {
				sb.append(ch);
			}
			System.out.println(sb);
		}
	}
}
