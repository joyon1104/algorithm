package baekjoon;
import java.util.*;
/*
 * [���ο� ���� 2]
 * - ����
 * - �ٽ� Ǯ ��!!
 */

public class p17837_1 {

	static int N,K;
	static int[][] board;
	static int[][] horse;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		board = new int[N+1][N+1]; //ü���� ���� ���� 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)
				board[i][j] = sc.nextInt();
		}
		
		String[][] map = new String[N+1][N+1]; // �� ���� ���¸� string���� ���� 
		horse = new int[K][3];  // �� �� ��,��,�̵����� ���� 
		for(int i=0; i<K; i++) {
			horse[i][0] = sc.nextInt();
			horse[i][1] = sc.nextInt();
			horse[i][2] = sc.nextInt();
			map[horse[i][0]][horse[i][1]] = Integer.toString(i);
		}
		
		int turn = 0;
		int[][] move = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
		while(turn<=1000) {
			turn++;
			boolean check = false;
			for(int k=0; k<K; k++) {
				int r = horse[k][0];
				int c = horse[k][1];
				int d = horse[k][2];
				int next_r = r + move[d][0];
				int next_c = c + move[d][1];
				int color = 0;
				if(next_r<=0|| next_c<=0|| next_r>N || next_c>N)
					color = 2;
				else
					color = board[next_r][next_c];
				
				if(color==0) {
					if(map[r][c].indexOf(Integer.toString(k)) == 0) {
						if(map[next_r][next_c]==null)
							map[next_r][next_c] = map[r][c];
						else
							map[next_r][next_c]+=map[r][c];
						horse = change(horse, map[r][c], next_r, next_c);
						map[r][c] = "";
					}
					else {
						int idx = map[r][c].indexOf(Integer.toString(k));
						if(map[next_r][next_c]==null)
							map[next_r][next_c] = map[r][c].substring(idx);
						else
							map[next_r][next_c] += map[r][c].substring(idx);
						horse = change(horse, map[r][c].substring(idx), next_r, next_c);
						map[r][c] = map[r][c].substring(0,idx);
					}
				}
				else if(color==1) {
					if(map[r][c].indexOf(Integer.toString(k)) == 0) {
						String s = reverseHorse(map[r][c]);
						if(map[next_r][next_c] == null)
							map[next_r][next_c] = s;
						else
							map[next_r][next_c] += s;
						horse = change(horse, s, next_r, next_c);
						map[r][c] = "";
					}
					else {
						int idx = map[r][c].indexOf(Integer.toString(k));
						String s = reverseHorse(map[r][c].substring(idx));
						if(map[next_r][next_c]==null)
							map[next_r][next_c] = s;
						else
							map[next_r][next_c] += s;
						horse = change(horse, s, next_r, next_c);
						map[r][c] = map[r][c].substring(0,idx);
					}
				}
				else{
					if(d==1) horse[k][2] = 2;
					else if(d==2) horse[k][2] = 1;
					else if(d==3) horse[k][2] = 4;
					else horse[k][2] = 3;
					next_r = r + move[horse[k][2]][0];
					next_c = c + move[horse[k][2]][1];
					if(next_r<=0 || next_c<=0 || next_r>N || next_c>N || board[next_r][next_c] == 2)
						continue;
					else k--;
				}
				if(map[next_r][next_c] != null && map[next_r][next_c].length()>=4) {
					check = true;
					break; //while�� break�� �ƴ� for�� break���� ��������!
				}
			}
			if(check==true) // �� 4�� �̻� ���̸� break
				break;
		}
		
		if(turn>1000)
			turn = -1;
		System.out.println(turn);
	}
	
	// �ű� ��(string����)�� ���� horse �迭 ���� ����
	static int[][] change(int[][] horse, String s, int r, int c){
		int[][] tmp = new int[K][3];
		for(int i=0; i<K; i++) {
			for(int j=0; j<3; j++) {
				tmp[i][j] = horse[i][j];
			}
		}
		
		for(int i=0; i<s.length(); i++) {
			int n = Integer.parseInt(s.substring(i,i+1));
			tmp[n][0] = r;
			tmp[n][1] = c;
		}
		return tmp;
	}
	
	// ���� ������ �ٲ�
	static String reverseHorse(String s) {
		StringBuilder tmp = new StringBuilder();
		for(int i=s.length()-1; i>=0; i--) {
			tmp.append(s.substring(i, i+1));
		}
		return tmp.toString();
	}
}
