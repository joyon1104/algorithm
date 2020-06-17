package baekjoon;
import java.util.*;

public class p17779 {

	static int N;
	static int result;
	static int[][] map;
	
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j){
			this.i = i; 
			this.j = j;
		}
	}
	
	public static void printmap(int[][] check) {
		for(int i=1; i<check.length; i++) {
			for(int j=1; j<check[0].length; j++) {
				System.out.print(check[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		result = Integer.MAX_VALUE;
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				for(int d2=1; j+d2<=N; d2++) {
					for(int d1=1; i+d1+d2<=N; d1++) {
						if(j-d1 >=1)
							solve(i,j,d1,d2);
					}
				}
			}
		}
		System.out.println(result);
	}
	
	static void solve(int i, int j, int d1, int d2) {
		int[][] check = new int[N+1][N+1];
		int[][] moved = {{1,1},{1,-1},{-1,-1},{-1,1}};
		int[][] move = {{0,1},{1,0},{-1,0},{0,-1}};
		int next_i = i;
		int next_j = j;
		
		// 5 지역구 경계값 -경계값만 체크
		for(int k=0; k<4; k++) {
			if(k%2 == 0) {
				for(int p=d2; p>0; p--) {
					next_i += moved[k][0];
					next_j += moved[k][1];
					check[next_i][next_j] = 5;
				}
			}
			else {
				for(int p=d1; p>0; p--) {
					next_i += moved[k][0];
					next_j += moved[k][1];
					check[next_i][next_j] = 5;
				}
			}
		}
		
		int total = 0; //5지역구 계산 (전체에서 각 지역구 인원을 뺀다)
		for(int p=1; p<=N; p++) {
			for(int q=1; q<=N; q++) {
				total += map[p][q];
				if(check[p][q] == 5)
					continue;
				if(p<i+d1 && q<=j)
					check[p][q] = 1;
				else if(p<=i+d2 && j<q)
					check[p][q] = 2;
				else if(i+d1 <= p && q < j-d1+d2)
					check[p][q] = 3;
				else if(i+d2<p && j-d1+d2<=q)
					check[p][q] = 4;
				else
					check[p][q] = 5;
			}
		}
		
		// 지역구 인원 계산
		int[][] point = {{1,1},{1,N},{N,1},{N,N}};	//각 꼭지점
		int[] people = new int[6];	// 각 지역구 인원을 저장하는 배열
		people[5] = total;
		for(int k=0; k<4; k++) {
			int[][] visited = new int[N+1][N+1];
			Queue<Pair> que = new LinkedList<>();
			que.offer(new Pair(point[k][0],point[k][1]));
			visited[point[k][0]][point[k][1]] = 1;
			int idx = check[point[k][0]][point[k][1]];
			int sum = 0;
			while(!que.isEmpty()) {
				Pair p = que.poll();
				sum += map[p.i][p.j];
				for(int m=0; m<4; m++) {
					int ni = p.i + move[m][0];
					int nj = p.j + move[m][1];
					if(ni>=1 && nj>=1 && ni<=N && nj<=N) {
						if(check[ni][nj]==idx && visited[ni][nj]==0) {
							que.offer(new Pair(ni,nj));
							visited[ni][nj] = 1;
						}
					}
				}
			}
			people[idx] = sum;
			people[5] -= sum;
		}
		
		Arrays.sort(people);
		// 최솟값 갱신
		if(result > people[5]-people[1])
			result = people[5]-people[1];
	}
}
