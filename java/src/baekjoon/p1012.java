package baekjoon;

import java.util.Scanner;

/*
 * 190809
 * 
 * 백준 1012번
 * -> 분류 : DFS
 * DFS 참고자료 
 * : https://ktko.tistory.com/entry/%ED%83%90%EC%83%89%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B9%8A%EC%9D%B4-%EC%9A%B0%EC%84%A0-%ED%83%90%EC%83%89DFS-Depth-First-Search
 * 
 * [ 유기농 배추 ]
 * 
 * => 성공
 */

public class p1012 {
	static Scanner sc = new Scanner(System.in);
	static int M;
	static int N;
	static int K;
	static int[][] map;
	static int[][] visited;
	static int bug;
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		
		for(int testcase = 0; testcase < T; testcase++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[M][N];
			visited = new int[M][N];
			
			int i = 0;
			int j = 0;
			
			for(int k=0; k<K; k++) {
				i = sc.nextInt();
				j = sc.nextInt();
				map[i][j] = 1;
			}
			
			bug = 0;
			
			for(int p =0; p<M; p++) {
				for(int q=0; q<N; q++) {
					if(map[p][q] == 1 && visited[p][q] == 0)	// 처음 DFS탐색을 시작할 때 벌레를 센다.
						bug++;
					DFS(p,q);
				}
			}
			System.out.println(bug);
		}
	}
	
	static void DFS(int p, int q) {	
		if(map[p][q] != 1 && visited[p][q] == 0 ) {	//map에 벌레가 없고, 한번도 방문하지 않은 경우 -> 탐색했으므로 방문 표시만.
			visited[p][q] = 1;
		}
		else if(map[p][q] == 1 && visited[p][q] == 0) {		//map에 벌레가 있고, 한번도 방문하지 않은 경우 -> 방문 표시와 동서남북 DFS.
			visited[p][q] = 1;
			if(p-1>=0 && map[p-1][q] == 1 && visited[p-1][q] == 0) DFS(p-1,q);
			if(p+1<M && map[p+1][q] == 1 && visited[p+1][q] == 0) DFS(p+1,q);
			if(q-1>=0 && map[p][q-1] == 1 && visited[p][q-1] == 0) DFS(p,q-1);
			if(q+1<N && map[p][q+1] == 1 && visited[p][q+1] == 0) DFS(p,q+1);
		}
	}
	
}
