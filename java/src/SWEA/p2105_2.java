package SWEA;
import java.util.*;

/*
 * [����Ʈ ī��]
 * - ����
 */

public class p2105_2 {
	
	static int N;
	static int max;
	static int start_i,start_j;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			max = -1;
			N = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int[] dessert = new int[101]; // 0: �������� ����, 1:������, -1:������
					dessert[map[i][j]] = -1; 
					// ������ �������� �ʱ�ȭ
					start_i = i;
					start_j = j; 
					if(i+1<N && j+1<N && dessert[map[i+1][j+1]]==0) {	//**�������� �������� ����Ʈ ������ ���� ��� ����
						dessert[map[i+1][j+1]] = 1;
						solve(map,dessert,i+1,j+1,0,1,0);
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
	
	// ���� ����Ʈ���� or ���� ������ ��ǥ���� �Ǵ��ϴ� �Լ�
	static boolean isPossible(int[][]map, int[]dessert, int i, int j) {
		boolean res = true;
		if(i<0 || j<0 || i>=N || j>=N)
			res = false;
		else if(i==start_i && j==start_j)
			res = true;
		else if(dessert[map[i][j]]!=0)
			res = false;
		return res;
	}
	
	static void solve(int[][] map, int[] dessert, int i, int j, int d, int a, int b) {
		int[][] move = {{1,1},{1,-1},{-1,-1},{-1,1}};
		int next_i = 0;
		int next_j = 0;
		if(d==0) { //�����ʾƷ�
			next_i = i + move[d][0];
			next_j = j + move[d][1];
			if(isPossible(map,dessert,next_i,next_j)) {
				dessert[map[next_i][next_j]] = 1;
				solve(map,dessert,next_i,next_j,d,a+1,b);
				dessert[map[next_i][next_j]] = 0;
			}
			next_i = i + move[d+1][0];
			next_j = j + move[d+1][1];
			if(isPossible(map,dessert,next_i,next_j)) {
				dessert[map[next_i][next_j]] = 1;
				solve(map,dessert,next_i,next_j,d+1,a,b+1);
				dessert[map[next_i][next_j]] = 0;
			}
		}
		else if(d==1) { //���ʾƷ�
			next_i = i + move[d][0];
			next_j = j + move[d][1];
			if(isPossible(map,dessert,next_i,next_j)) {
				dessert[map[next_i][next_j]] = 1;
				solve(map,dessert,next_i,next_j,d,a,b+1);
				dessert[map[next_i][next_j]] = 0;
			}
			next_i = i + move[d+1][0];
			next_j = j + move[d+1][1];
			if(isPossible(map,dessert,next_i,next_j)) {
				dessert[map[next_i][next_j]] = 1;
				solve(map,dessert,next_i,next_j,d+1,a-1,b);
				dessert[map[next_i][next_j]] = 0;
			}
		}
		else if(d==2) {  //������
			if(a==0) {
				solve(map,dessert,i,j,d+1,a,b);
			}
			else {
				next_i = i + move[d][0];
				next_j = j + move[d][1];
				if(isPossible(map,dessert,next_i,next_j)) {
					dessert[map[next_i][next_j]] = 1;
					solve(map,dessert,next_i,next_j,d,a-1,b);
					dessert[map[next_i][next_j]] = 0;
				}
			}
		}
		else if(d==3) { //������ �� 
			if(b==0) {
				if(i==start_i && j==start_j) {
					int result = 0;
					for(int k=1; k<=100; k++) { //0�� �ƴ� �� -> ������ ����Ʈ
						if(dessert[k] !=0)
							result++;
					}
					if(result > max) {
						max = result;
					}
				}
			}
			else {
				next_i = i + move[d][0];
				next_j = j + move[d][1];
				if(isPossible(map,dessert,next_i,next_j)) {
					if(dessert[map[next_i][next_j]] ==0)
						dessert[map[next_i][next_j]] = 1;
					solve(map,dessert,next_i,next_j,d,a,b-1);
					if(dessert[map[next_i][next_j]] ==1)
						dessert[map[next_i][next_j]] = 0;
				}
			}
		}
	}

}
