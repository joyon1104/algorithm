package baekjoon;
import java.util.*;

public class p2146 {
	
	static int N;
	static int[][] map;
	static int[][] visited;
	static int[][] bridge;
	static int min;
	static int[][] moved = {{0,1},{1,0},{-1,0},{0,-1}};
	static Queue<Pair> q = new LinkedList<Pair>();
	
	static class Pair{
		int x; 
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];  // 처음 input받을 섬 지도
		visited = new int[N][N];  // dfs, bfs를 위한 방문여부 표시 
		bridge = new int[N][N];  // 다리 길이 계산을 위한 배열
		min = 2*N*N;
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 각각의 섬을 숫자로 다르게 표시하기
		int cnt = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && visited[i][j]==0) {
					dfs(i,j,cnt);   // dfs 한번 돌때마다 cnt 증가
					cnt++;
				}
			}
		}
//		printMap(map);
		
		visited = new int[N][N]; // visited 초기화
		// 섬을 확장(다리 길이측정)하기 위해 섬의 인덱스를 큐에 저장
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]!=0)  // **** 섬이 1이상의 숫자들로 표시되어서 0이 아닌 수로 섬을 비교!
					q.add(new Pair(i,j));
			}
		}
		
		// 섬 확장을 위한 bfs => 바다를 섬으로 매꾼다고 생각.
		bfs_expand();
		
		// 다른 섬과 인접한 bridge들을 더해 섬사이의 다리 길이를 구한다.
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<4; k++) {
					int nx = i + moved[k][0];
					int ny = j + moved[k][1];
					if(nx>=0 && ny>=0 && nx<N && ny<N) {
						if(map[i][j] != map[nx][ny]) { // 서로 다른 섬끼리 인접하면 다리 생성 후 최솟값 갱신
							int tmp = bridge[i][j] + bridge[nx][ny];
							if(min>tmp)
								min = tmp;
						}
					}
				}
			}
		}
		printMap(map);
		
		System.out.println(min);
		
	}
	
	public static void printMap(int[][] MAP) {
        for (int i = 0 ; i< N; i++) {
            for(int j =0 ; j < N ; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	static void bfs_expand() {
		while(!q.isEmpty()) {
			Pair temp = q.poll();
			for(int i=0; i<4; i++) {
				int nx = temp.x + moved[i][0];
				int ny = temp.y + moved[i][1];
				if(nx>=0 && ny>=0 && nx<N && ny<N) {
					if(bridge[nx][ny]==0 && map[nx][ny]==0) { // 섬이 아직 확장되지 않았고, 바다이면..
						bridge[nx][ny] = bridge[temp.x][temp.y]+1; // 이전 bridge에 +1한 값. 
						map[nx][ny] = map[temp.x][temp.y];  // 섬확장
						q.add(new Pair(nx,ny));
					}
				}
			}
		}
	}
	
	
	static void dfs(int x, int y, int cnt) {
		visited[x][y] = 1;
		map[x][y] = cnt;
		
		for(int i=0; i<4; i++) {
			int nx = x + moved[i][0];
			int ny = y + moved[i][1];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(visited[nx][ny]==0 && map[nx][ny]==1)
					dfs(nx,ny,cnt);
			}
		}
	}

}
