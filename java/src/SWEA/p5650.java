package SWEA;
import java.util.*;

public class p5650 {
	
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int N;
	static int max;
	static int[][] map;
	static HashMap<Integer, ArrayList<Pair>> hm;
	static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			max = 0;
			N = sc.nextInt();
			map = new int[N][N];
			hm = new HashMap<>();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]>=6 && map[i][j]<=10) {
						if(hm.containsKey(map[i][j])) {
							hm.get(map[i][j]).add(new Pair(i,j));
						}
						else {
							ArrayList<Pair>tmp = new ArrayList<>();
							tmp.add(new Pair(i,j));
							hm.put(map[i][j],tmp);
						}
					}
				}
			}
			
			//시작
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==0) {
						for(int d=0; d<4; d++) { //이동방향 : 0:위,1:아래:,2:왼쪽,3:오른쪽
							solve(i,j,d);
						}
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
	
	static void solve(int i, int j, int d) {
		int start_i = i;
		int start_j = j;
		int score = 0;
		while(true) {
			int next_i = i + move[d][0];
			int next_j = j + move[d][1];

			// 종료조건
			if(next_i<0 || next_j<0 || next_i>=N || next_j>=N) {
				d = direction(d,-1); //반대방향
				i = next_i;
				j = next_j;
				score++;
				continue;
			}
			
			
			if((next_i==start_i && next_j==start_j) || map[next_i][next_j]==-1)
				break;
			
			// 블록
			if(map[next_i][next_j] >=1 && map[next_i][next_j] <=5) {
				if(map[next_i][next_j]==1) {
					if(d==0 || d==3)
						d = direction(d,-1);
					else if(d==1) d = direction(d,2); //왼쪽
					else d = direction(d,1);   		//오른쪽
				}
				else if(map[next_i][next_j]==2) {
					if(d==1 || d==3)
						d = direction(d,-1);
					else if(d==2) d = direction(d,2);
					else d = direction(d,1);
				}
				else if(map[next_i][next_j]==3) {
					if(d==1 || d==2)
						d = direction(d,-1);
					else if(d==0) d = direction(d,2);
					else d = direction(d,1);
				}
				else if(map[next_i][next_j]==4) {
					if(d==0 || d==2)
						d = direction(d,-1);
					else if(d==3) d = direction(d,2);
					else d = direction(d,1);				
				}
				else{
					d = direction(d,-1);
				}
				score++;
			}
			
			//웜홀
			else if(map[next_i][next_j] >=6 && map[next_i][next_j] <=10) {
				if(hm.get(map[next_i][next_j]).get(0).i ==next_i && hm.get(map[next_i][next_j]).get(0).j ==next_j){
					Pair p = hm.get(map[next_i][next_j]).get(1);	//변수사용 잘하기!
					next_i = p.i;
					next_j = p.j;
				}
				else {
					Pair p = hm.get(map[next_i][next_j]).get(0);
					next_i = p.i;
					next_j = p.j;
				}
			}
			
			// 초기화
			i = next_i;
			j = next_j;
		}
		
		if(max < score)
			max = score;
	}
	
	static int direction(int d, int state) {
		int result = 0;
		if(state == -1) { //반대방향
			if(d==0) result = 1;
			else if(d==1) result = 0;
			else if(d==2) result = 3;
			else result = 2;
		}
		
		else if(state == 1) { // 수직 오른쪽
			if(d==0) result = 3;
			else if(d==1) result = 2;
			else if(d==2) result = 0;
			else result = 1;
		}
		else if(state == 2) {  //수직 왼쪽
			if(d==0) result = 2;
			else if(d==1) result = 3;
			else if(d==2) result = 1;
			else result = 0;
		}
		return result;
	}
}
