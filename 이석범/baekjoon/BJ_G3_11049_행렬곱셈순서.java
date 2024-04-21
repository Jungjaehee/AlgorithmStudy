package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author SEOK BEOM LEE
 *	13924kb 208ms
 */
public class BJ_G3_11049_��İ������� {
	

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] input = new int[n+1];
        int[][] dp = new int[n][n];

        //5 3, 3 2, 2 6�� ���� ��� 3 3 �� ���� 2 2�� �����Ƿ�
        //n+1���� �Է� ����
        //���������� 5 3 2 6
        for(int i=0; i<n;i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = Integer.parseInt(st.nextToken());
            input[i+1] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(input));
        
        //n�� 1�̸� 0���
        if(n==1) {
            System.out.println(0);
        }
        else {
        	//���� ���� 0~2, 0~3 ...���� ��
        	for(int i=2; i<n+1;i++) {
        		//0���� ����
        		for(int j=0; i+j<n+1;j++) {
        			
        			dp[j][i+j-1] = Integer.MAX_VALUE;
        			//k�� �������� ���� ������ ����� ��� �� ��ħ
        			for(int k=j; k<i+j-1;k++) {
        				int value = dp[j][k] + dp[k+1][j+i-1] + (input[j]*input[k+1]*input[j+i]);
        				//�ּڰ�
    					dp[j][j+i-1] = Math.min(dp[j][j+i-1], value);
        			}
        		}
        	}
        	System.out.println(dp[0][n-1]);
        }


    }
}