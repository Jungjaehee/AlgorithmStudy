package test;

import java.util.Scanner;
import java.util.Stack;

//31940kb 552ms
public class BJ_G4_16120_PPAP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		
		//�߰� ���� �ϱ� ���� stack���� �ϱ�
		Stack<Integer> stack = new Stack<>();
//		Deque<Integer> stack1 = new ArrayDeque<>();
		
		for(int i=0; i<input.length();i++) {
			int text = input.charAt(i);
			
			//A�� ��� ���ÿ� �ֱ�
			if(text=='A') {
				stack.push(text);
			}
			//'P' �� ���
			else {
				int size = stack.size();
				//�տ� 'A'�̰� 'PPA' �� ��� 'A', 'P' �ΰ��� ���� ��
				if(size>=3 && stack.peek()=='A' ) {
					if(stack.get(size-2) == 'P' && stack.get(size-3)=='P') {
						for(int j=0; j<2;j++) {
							stack.pop();
						}
					}
				}
				else {
					stack.push(text);
				}
			}
		}
		
		//������ ��� �غ���, P�ϳ��� �־����
		//stack.forEach(System.out::println);
		
		if(stack.size()==1 && stack.peek()=='P') {
			System.out.println("PPAP");
		}
		else {
			System.out.println("NP");
		}
	}
}
