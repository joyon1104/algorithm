package SWEA;
import java.util.*;

public class p2382_1 {
	
	static public class Microbe{
		int cnt;
		int d;
		
		public Microbe(int cnt, int d) {
			this.cnt = cnt;
			this.d = d;
		}
	}
	
	static public Microbe[][] solve(Microbe[][] map){
		Microbe[][] result = new Microbe[map.length][map.length];
		int[][] check = new int[map.length][map.length];
		int[][] moved = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(map[i][j] != null) {
					Microbe m = map[i][j];
					int next_i = i+moved[m.d][0];
					int next_j = j+moved[m.d][1];
					if(next_i==0 || next_j==0 ||next_i==map.length-1 || next_j==map.length-1) {	// 약품에 닿을 경우
						//개수감소
						m.cnt /= 2;
						if(m.cnt==0)
							continue;
						//방향변경
						if(m.d==1)	m.d = 2;
						else if(m.d==2) m.d = 1;
						else if(m.d==3) m.d = 4;
						else if(m.d==4) m.d = 3;
					}
					
					if(result[next_i][next_j] != null) {
						if(check[next_i][next_j] < m.cnt) {
							result[next_i][next_j].d = m.d;
							check[next_i][next_j] = m.cnt;
						}
						result[next_i][next_j].cnt += m.cnt;
					}
					else {
						result[next_i][next_j] = m;
						check[next_i][next_j] = m.cnt;
					}
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			Microbe[][] map = new Microbe[N][N];
			
			for(int k=0; k<K; k++) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				int cnt = sc.nextInt();
				int d = sc.nextInt();
				map[i][j] = new Microbe(cnt,d);
			}
			
			int time = 0;
			while(time<M) {
				map = solve(map);
				time++;
			}
			
			int result = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] != null)
						result += map[i][j].cnt;
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
}
